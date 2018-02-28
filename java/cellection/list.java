/*

add(e)

get(index)

set(index, e)

remove(index)

indexOf(e);  第一个

lastIndexOf(e);  最后一个

Clear();

*/
		
		List<Integer>lst = new ArrayList<>(); //或者是linkedlist
		for(int i=0;i<10;i++) {
			lst.add(i);
			lst.add(i);			
			lst.add(i);
		}
				
		System.out.println(lst);
		System.out.println("size == "+lst.size());
		System.out.println("isEmpty=="+lst.isEmpty());
		System.out.println("hashcode=="+lst.hashCode());
		
		System.out.println("first index of (2) == "+lst.indexOf(2));
		System.out.println("last index of (2) == "+lst.lastIndexOf(2));	
		
		
		System.out.println("6th element == "+lst.get(6));	
		System.out.println("6th element == "+lst.remove(6));	
		System.out.println(lst);
		lst.clear();
		System.out.println(lst);
		
