/*

add(e)

get(index)

set(index, e)

remove(index)

indexOf(e);  第一个

lastIndexOf(e);  最后一个

Clear();

*/

		List<Integer>lst = new ArrayList<>();
		for(int i=0;i<10;i++) {
			lst.add(i);
			lst.add(i);			
			lst.add(i);
		}
				
		System.out.println(lst);
		System.out.println(lst.size());
		System.out.println(lst.isEmpty());
		System.out.println(lst.hashCode());
		
		System.out.println(lst.indexOf(2));
		System.out.println(lst.lastIndexOf(2));	
		
		
		System.out.println(lst.get(6));	
		System.out.println(lst.remove(6));	
		System.out.println(lst);
		
