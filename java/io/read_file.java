
		File file = new File("d:\\zhaojinzhou.txt");
		
		try {
			Scanner file_in = new Scanner(file);
			
			while(file_in.hasNext()) {
				System.out.println(file_in.nextLine());
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
