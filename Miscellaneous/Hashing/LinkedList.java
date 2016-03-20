/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithmshomeworks;

import java.util.ArrayList;

/**
 *
 * @author Ushang-PC
 */
class Node 
{
    private Node next;
    private String key;
    private int value;

    public String getKey() 
    {
        return key;
    }
    public void setKey(String key) 
    {
        this.key = key;
    }
    public Node getNext() 
    {
        return next;
    }
    public void setNext(Node next) 
    {
        this.next = next;
    }
    public int getValue()
    {
        return value;
    }
    public void setValue(int value)
    {
        this.value = value;
    }	
}

public class LinkedList {
    
    private Node head;

    public Node getHead() 
    {
        return head;
    }

    public void setHead(Node head) 
    {
        this.head = head;
    }
    
    public Node insert(String key, int value)
    {
        Node found = findElement(key);

        if(found != null)
        {
            found.setValue(value);
        }
        else
        {
            Node temp = new Node();
            temp.setKey(key);
            temp.setValue(value);
            if(getHead() == null)
            {
                setHead(temp);
            }
            else
            {
                getLastNode().setNext(temp);
            }
        }
        return head;
    }
    
    public Node increaseValue(String key, int incrementBy)
    {
        Node found = findElement(key);

        if(found != null)
        {
            found.setValue(found.getValue() + incrementBy);
        }
        else
        {
            Node temp = new Node();
            temp.setKey(key);
            temp.setValue(incrementBy);
            if(getHead() == null)
            {
                setHead(temp);
            }
            else
            {
                getLastNode().setNext(temp);
            }
        }
        return head;
    }
    
    public Node findElement(String key)
    {
        Node temp = getHead();
        while(temp!=null)
        {
            if(temp.getKey().equals(key))
            {
                    return temp;
            }
            temp = temp.getNext();
        }
        return null;
    }

    public Node getLastNode()
    {
        Node temp = getHead();
        while(temp!= null)
        {
            if(temp.getNext() == null)
            {
                return temp;
            }
            temp = temp.getNext();
        }
        return null;
    }
		
    public int listSize()
    {
        int size = 0;
        Node temp = getHead();
        while(temp != null)
        {
            temp = temp.getNext();
            size++;
        }
        return size;
    }

    public void printList()
    {
        Node temp = getHead();
        while(temp != null)
        {
            System.out.print("[" + temp.getKey() + ", " + temp.getValue()+"] ");
            temp = temp.getNext();
        }
        System.out.println();
    }

    public ArrayList<String> getAllKeys()
    {
        ArrayList<String> keys = new ArrayList<String>();
        Node temp = getHead();
        while(temp!=null)
        {
            keys.add(temp.getKey());
            temp = temp.getNext();
        }
        return keys;
    }

    public void delete(String key)
    {
        Node temp = getHead();
        Node prev = null;
        while(temp!= null)
        {
            if(temp.getKey().equals(key))
            {
                break;
            }
            prev = temp;
            temp = temp.getNext();
        }
        if(temp != null)
        {
            if(prev == null)
            {
                setHead(temp.getNext());
            }
            else
            {
                prev.setNext(temp.getNext());
            }
        }
    }

}
