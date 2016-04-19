package homework9;

public class BinomialHeap 
{
	int count;

	// Binomial Tree
	public class BinomialTree 
	{
		BinomialTree parent;
		BinomialTree sibiling;
		BinomialTree child;
		int key;
		int degree;

		public BinomialTree(int key) 
		{
			this.parent = INFINITTY;
			this.sibiling = INFINITTY;
			this.child = INFINITTY;
			this.key = key;
			this.degree = 1;
		}
	}
	
	public static final int INFINIT = 2147483647;
	private static BinomialHeap NILsupport = new BinomialHeap();
	public static BinomialTree INFINITTY = NILsupport.new BinomialTree(INFINIT);
	private BinomialTree head = INFINITTY;
	
	public BinomialTree extractMin(BinomialHeap h) 
	{

		BinomialTree prevOfmin = INFINITTY;
		BinomialTree min = h.head;
		BinomialTree next = min.sibiling;
		BinomialTree temp = min;

		if (h.head == INFINITTY)
		{
			return INFINITTY;
		}

		while (next != INFINITTY) 
		{

			if (min.key <= next.key) 
			{
				min = next;
				prevOfmin = temp;
			}
			temp = next;
			next = next.sibiling;
		}

		if (min == h.head) 
		{
			this.head = min.sibiling;
		}
		else 
		{
			prevOfmin.sibiling = min.sibiling;
		}

		BinomialTree minchild = min.child;
		BinomialTree tempsibiling = INFINITTY;

		while (minchild != INFINITTY)
		{
			next = minchild.sibiling;
			minchild.sibiling = tempsibiling;
			minchild.parent = INFINITTY;
			tempsibiling = minchild;
			minchild = next;
		}

		BinomialHeap BH1 = new BinomialHeap();
		BH1.head = tempsibiling;
		binomial_heap_union(BH1);

		return min;
	}

	public void insert(int keyy)
	{
		verifyNIL();
		BinomialTree node = new BinomialTree(keyy);
		BinomialHeap BHnew = new BinomialHeap();
		node.parent = INFINITTY;
		node.child = INFINITTY;
		node.sibiling = INFINITTY;
		node.degree = 1;
		BHnew.head = node;
		binomial_heap_union(BHnew);
	}

	public void binomial_link(BinomialTree y, BinomialTree z)
	{
		y.parent = z;
		y.sibiling = z.child;
		z.child = y;
		z.degree = z.degree + y.degree;
	}

	public BinomialTree merge(BinomialHeap H2) 
	{
		BinomialTree bt1 = this.head;
		BinomialTree bt2 = H2.head;

		if ((bt1 != INFINITTY) && (bt2 != INFINITTY)) 
		{
			BinomialTree bt3 = INFINITTY;
			if (bt1.degree < bt2.degree) 
			{
				this.head = bt1;
			} 
			else 
			{
				this.head = bt2;
			}
			
			if (this.head == INFINITTY) 
			{
				return this.head;
			}
			if (this.head == bt2) 
			{
				bt2 = bt1;
			}
			bt1 = this.head;
			while (bt2 != INFINITTY) 
			{
				if (bt1.sibiling == INFINITTY) 
				{
					bt1.sibiling = bt2;
					return this.head;
				} 
				else if (bt1.sibiling.degree < bt2.degree) 
				{
					bt1 = bt1.sibiling;
				} 
				else 
				{
					bt3 = bt2.sibiling;
					bt2.sibiling = bt1.sibiling;
					bt1.sibiling = bt2;
					bt1 = bt1.sibiling;
					bt2 = bt3;
				}
			}
		} 
		else 
		{
			if (bt1 != INFINITTY) 
			{
				this.head = bt1;
			} 
			else 
			{
				this.head = bt2;
			}
		}
		return this.head;
	}

	public int  minumum(BinomialHeap h) 
	{
		BinomialTree y = INFINITTY;
		BinomialTree x = h.head;
		int min = 2147483647;
		while (x != INFINITTY) 
		{ 
			if (x.key < min) 
			{
				min = x.key;
				y = x;
			}
			x = x.sibiling; 
		}
		return y.key;
	}

	public BinomialHeap binomial_heap_union(BinomialHeap h)
	{
		BinomialHeap bhnew = new BinomialHeap();
		bhnew.head = merge(h);
		if (this.head != INFINITTY) 
		{
			BinomialTree prev_x = INFINITTY;
			BinomialTree x = bhnew.head;
			BinomialTree next_x = x.sibiling;
			while (next_x != INFINITTY) 
			{
				if ( (x.degree != next_x.degree)||( (next_x.sibiling != INFINITTY)&&(next_x.sibiling.degree == x.degree) ) ) 
				{
					prev_x = x;
					x = next_x;
				} 
				else 
				{ 
					if (x.key <= next_x.key) 
					{
						x.sibiling = next_x.sibiling;
						binomial_link(next_x,x);
					}
					else
					{ 
						if (prev_x == INFINITTY) 
						{
							this.head = next_x;
						}
						else 
						{
							prev_x.sibiling = next_x;
						}
						binomial_link(x,next_x);
						x = next_x;
					}
				}
				next_x = x.sibiling;
			}
		}
		return bhnew;
	}

	public void delete( BinomialTree t)
	{
		decrease_key(this, t,Integer.MIN_VALUE);
		extractMin(this);
	}
	
	
	public void decrease_key(BinomialHeap h, BinomialTree t, Integer k)
	{
		int temp;
		BinomialTree y = INFINITTY;
		BinomialTree z;
		
		if (t.key < k)
		{
			System.out.println("New key is greater then the current key.");
			return;
		}
		t.key = k;
		y = t;
		z = y.parent;
		while (z !=INFINITTY && y.key <z.key)
		{
			temp = y.key;
			y.key = z.key;
			z.key = temp;
			y= z;
			z = y.parent;
		}
	}
	
	public BinomialTree find (BinomialTree root, int e)
	{
		BinomialTree x = root;
		BinomialTree temp = INFINITTY;
		
		if(x.key == e) 
		{
			temp =x;
			return temp;
		}
		
		if (x.child != INFINITTY && temp  == INFINITTY) 
		{
			temp = find(x.child,e);
		}
		if (root.sibiling != INFINITTY && temp  == INFINITTY) 
		{
			temp = find(x.sibiling,e);
		}
		return temp;
	}
	
	private void verifyNIL() 
	{
		INFINITTY.child = INFINITTY;
		INFINITTY.parent = INFINITTY;
		INFINITTY.sibiling = INFINITTY;
	}
	
	public void buildHeap(int[] array) 
	{
		verifyNIL();
		if (array.length > 0) 
		{ 
			BinomialTree start = new BinomialTree(array[0]); 
			this.head = start; 
			for (int i = 1; i < array.length; i++) 
			{
				System.out.println("Inserting "+array[i]);
				this.insert(array[i]);
			}
		} 
		else
		{ 
			this.head = INFINITTY;
		}
		System.out.println("Insertion Complete");
	}

public void printList(BinomialTree root) 
{
	if (root == this.head) 
	{
		System.out.println("key = " + root.key + ", degree = " + root.degree + ", TYPE = root");
	}
	if (root.child != INFINITTY) 
	{
		System.out.println("key = " + root.child.key + ", degree = " + root.child.degree + ", TYPE = child");
		printList(root.child);
	}
	if (root.sibiling != INFINITTY) 
	{
		System.out.println("key=" + root.sibiling.key + ", degree = " + root.sibiling.degree + ", TYPE = sibling");
		printList(root.sibiling);
	}
}
	
	
public static void main(String arg[])
{
	int input[] = {8, 15, 6, 36, 9, 11, 77, 2, 45};
	
	BinomialHeap myheap = new BinomialHeap();
	myheap.buildHeap(input);

	System.out.println("\nHEAP :: ");
	myheap.printList(myheap.head);

	System.out.println("\n Reduce the value from 77 to 19 :: ");
	myheap.decrease_key(myheap,myheap.find(myheap.head,77),19);
	System.out.println("HEAP :: ");
	myheap.printList(myheap.head);
	
	System.out.println("\nDelete key 9 :: ");
	myheap.delete(myheap.find(myheap.head,9));
	System.out.println("HEAP :: ");
	myheap.printList(myheap.head);
}
	
}

