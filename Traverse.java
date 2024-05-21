import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Traverse {
	
	public static void main(String[] args) {
		
		BufferedReader objReader = null;
		try{
			String satir;
		 
			Graph graph = new Graph();
			long startTime = System.nanoTime();
			
			
			objReader = new BufferedReader(new FileReader(args[0]));
		 
			int kelimeSayisi=0;
			String kelimelerSatir="";
			while ((satir = objReader.readLine()) != null){
				
				
				kelimelerSatir=satir;
				graph.addEdge(kelimelerSatir);
				//System.out.println(kelimelerSatir);
				kelimeSayisi++;
			}
			String paths;
			if(args[2].equals("-BF") && args[3].equals("-AL")) {
				System.out.print("Breadth-first : ");
				paths=graph.BFforList(args[1]);
				paths=paths.substring(0,paths.lastIndexOf('-')-1);
				System.out.print(paths);
				System.out.println();
				long endTime   = System.nanoTime();
				long totalTime = endTime - startTime;
				System.out.println("Time : "+totalTime);
				
			}else if(args[2].equals("-BF") && args[3].equals("-AM")) {
				System.out.print("Breadth-first : ");
				paths=graph.BFforMatrix(args[1]);
				paths=paths.substring(0,paths.lastIndexOf('-')-1);
				System.out.print(paths);
				System.out.println();
				long endTime   = System.nanoTime();
				long totalTime = endTime - startTime;
				System.out.println("Time : "+totalTime);
				
				//System.out.print(graph.BFforMatrix(args[1]));
				
			}else if(args[2].equals("-DF") && args[3].equals("-AM")) {
				System.out.print("Depth-first : ");
				paths=graph.DFforMatrix(args[1]);
				paths=paths.substring(0,paths.lastIndexOf('-')-1);
				System.out.print(paths);
				System.out.println();
				long endTime   = System.nanoTime();
				long totalTime = endTime - startTime;
				System.out.println("Time : "+totalTime);
				
				
				//System.out.print(graph.DFforMatrix(args[1]));
				
			}else if(args[2].equals("-DF") && args[3].equals("-AL")) {
				System.out.print("Depth-first : ");
				paths=graph.DFforList(args[1]);
				paths=paths.substring(0,paths.lastIndexOf('-')-1);
				System.out.print(paths);
				System.out.println();
				long endTime   = System.nanoTime();
				long totalTime = endTime - startTime;
				System.out.println("Time : "+totalTime);
				
				//System.out.print(graph.DFforMatrix(args[1]));
			}
			
			
			
			
		}catch (IOException e) {
			e.printStackTrace();
		}finally{
			try {
			    if(objReader != null)
			    	objReader.close();
			}catch(IOException ex) {
				ex.printStackTrace();
			}
		}
		
		
		
	}
	
	
	

}
