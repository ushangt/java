/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithmshomeworks;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Ushang-PC
 */
public class Hashing {
    
    public static final int SIZE_PRIME = 701;
    public final static int HASH_PRIME = 7;
    private LinkedList[] hashTable = new LinkedList[SIZE_PRIME];
    
    public int hashValue(String s)
    {
        int hash = 0;
        for(int i=0; i< s.length(); i++)
        {
            hash += Math.pow(HASH_PRIME, i) * s.charAt(i);
        }
        return hash;
    }

    public void insert(String key, int value)
    {
        int hIndex = hashValue(key) % SIZE_PRIME;
        if(hashTable[hIndex] == null)
        {
            hashTable[hIndex] = new LinkedList();
        }
        hashTable[hIndex].insert(key, value);
    }

    public int find(String key)
    {
        int hIndex = hashValue(key) % SIZE_PRIME;
        if(hashTable[hIndex] != null && hashTable[hIndex].findElement(key) != null)
        {
            return hashTable[hIndex].findElement(key).getValue();
        }
        else
        {
            return 0;
        }
    }
    
    public void increase(String key, int value)
    {
        int hIndex = hashValue(key) % SIZE_PRIME;
        if(hashTable[hIndex] == null)
        {
            insert(key, 1);
        }
        else
        {
            hashTable[hIndex].increaseValue(key, 1);
        }
    }
    
    public void increase(String key)
    {
        increase(key, 1);
    }

    public void delete(String key)
    {
        int hIndex = hashValue(key) % SIZE_PRIME;
        if(hashTable[hIndex] == null || hashTable[hIndex].findElement(key) == null)
        {
            System.out.println("Key doesn't exist");
        }
        else
        {
            hashTable[hIndex].delete(key);
        }
    }

    public ArrayList<String> listAllKeys()
    {	
        ArrayList<String> keys = new ArrayList<String>();
        for(int i =0; i< hashTable.length; i++)
        {
            if(hashTable[i] != null)
            {
                keys.addAll(hashTable[i].getAllKeys());
            }
        }
        return keys;
    }

    public void printHashTable()
    {		
        for(int i =0; i< hashTable.length; i++)
        {
            if(hashTable[i] != null)
            {
                hashTable[i].printList();
            }
        }
    }
    
    public static void main(String[] args)
    {
        Scanner scanner = null;
        String text = null;
        try
        {
            FileReader file = new FileReader("alice_in_wonderland.txt");
            scanner = new Scanner(file);
            text = scanner.useDelimiter("\\A").next();
        }
        catch(Exception e)
        {
            System.err.println("Error while reading file." + e);
        }
        finally
        {
            scanner.close();
        }

        String[] splitStr = text.split("[\\W]");
        //System.out.println(splitStr.length);

        Hashing h = new Hashing();
        for(int i=0; i<splitStr.length; i++)
        {
            if(splitStr[i] !=null && !splitStr[i].isEmpty())
            {
                h.increase(splitStr[i]);
            }
        }
	
        h.printHashTable();
        
        PrintWriter pw = null;
        try 
        {
            pw = new PrintWriter("output.txt");
            int c = 0;
            for(String k: h.listAllKeys())
            {
                pw.println(k + " -> " + h.find(k));
                c++;
            }
            //System.out.println("TotalKeys = "+c);
        } 
        catch (FileNotFoundException e) 
        {
            System.out.println("Error writing to file");
            e.printStackTrace();
        }
        finally
        {
            pw.close();
        }

        
    }
    
}
