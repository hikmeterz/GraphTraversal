import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;
import java.util.Vector;



public class Graph {

	 ArrayList<ArrayList<String> > adjacency_list;//String labeled adjacency_list
	 int[][] adjacency_matrix;
	 String nodes;
	 boolean[] visited;
	 String path="";
	 
	 
	 public Graph() {
		 
		adjacency_list = new ArrayList<ArrayList<String> >();
		
	 }
	 public void addEdge(String satir){
		
		 String first= satir.charAt(0)+"";
		 String second = satir.charAt(4)+"";
		 boolean firstBulunduMu=false;
		 boolean secondBulunduMu=false;
		 for(int i=0;i<adjacency_list.size();i++){
		
			 if(adjacency_list.get(i).get(0).equals(first)) {
				 firstBulunduMu=true;
				 if(adjacency_list.get(i).indexOf(second)<0) {//yani yoksa...
					 adjacency_list.get(i).add(second);
					 
				
				 }
			 }
		
		 }
		 if(firstBulunduMu==false) {
			 ArrayList<String> e = new ArrayList<String>();
			 e.add(first);
			 e.add(second);
			 adjacency_list.add(e);
			 
		 }
		 int tut=0;
		 for(int i=0;i<adjacency_list.size();i++) {
				
				if(adjacency_list.get(i).get(0).equals(second)) {
					secondBulunduMu=true;
					tut=i;
				}
				
		 }
			
		 if(secondBulunduMu==false) {
			 ArrayList<String> e1 = new ArrayList<String>();
			 e1.add(second);
			 e1.add(first);
			 adjacency_list.add(e1);
		 }else {
			 adjacency_list.get(tut).add(first);
			 
		 }
	 
	 }
		 
	 /*public  void printGraph() { 
	     for (int i = 0; i < adjacency_list.size(); i++) { 
			 System.out.println("\nAdjacency list of vertex " + adjacency_list.get(i).get(0)); 
			 System.out.print("head"); 
			 for (int j = 0; j < adjacency_list.get(i).size(); j++){ 
				 System.out.print(" -> "+adjacency_list.get(i).get(j)); 
			 } 
			 System.out.println(); 
		 }
	 
		 
	 }*/
		 
	 public void sortForMatrix() {
			 
		 int n = adjacency_list.size();
		 
		 for(int i = 0; i < n-1; i++){ //first index haric.
	            
			 int min_idx = i; 
			 for (int j = i+1; j < n; j++) 
				 if (adjacency_list.get(j).get(0).charAt(0) < adjacency_list.get(min_idx).get(0).charAt(0)) 
					 min_idx = j; 
			  
			 ArrayList<String> temp = adjacency_list.get(min_idx); 
			 adjacency_list.set(min_idx,adjacency_list.get(i)); 
			 adjacency_list.set(i,temp); 
		 } 
		
		 
		 
	 }
	 
	 
	 public void sortLists() {
		 
		 for(int i=0;i<adjacency_list.size();i++) {
			 
			 alphabeticOrder(adjacency_list.get(i));
			 
		 }
		 
	 }
	 
	 public void sortLists1() {
		 
		 for(int i=0;i<adjacency_list.size();i++) {
			 
			 alphabeticOrderReverse(adjacency_list.get(i));
			 
		 }
		 
	 }
	 
	 public void alphabeticOrder(ArrayList<String> arr) {
		 
		 int n = arr.size();
		 
		 for(int i = 1; i < n-1; i++){ //first index haric.
	            
			 int min_idx = i; 
			 for (int j = i+1; j < n; j++) 
				 if (arr.get(j).charAt(0) < arr.get(min_idx).charAt(0)) 
					 min_idx = j; 
			  
			 String temp = arr.get(min_idx); 
			 arr.set(min_idx,arr.get(i)); 
			 arr.set(i,temp); 
		 } 
		 
	 }
	 
	 public void alphabeticOrderReverse(ArrayList<String> arr) {
		 
		 int n = arr.size();
		 
		 for(int i = 1; i < n-1; i++){ //first index haric.
	            
			 int min_idx = i; 
			 for (int j = i+1; j < n; j++) 
				 if (arr.get(j).charAt(0) > arr.get(min_idx).charAt(0)) 
					 min_idx = j; 
			  
			 String temp = arr.get(min_idx); 
			 arr.set(min_idx,arr.get(i)); 
			 arr.set(i,temp); 
		 } 
		 
	 }
	 
	 public void adjacencyMatrixOlustur() {
		 
		 adjacency_matrix= new int[adjacency_list.size()][adjacency_list.size()];
		 
		 sortForMatrix();
		 sortLists();
		 nodes="";
		 for(int i=0;i<adjacency_list.size();i++) {
			 
			 nodes+=adjacency_list.get(i).get(0);
			 
		 }
		 for(int i=0;i<adjacency_list.size();i++){
			 adjacency_matrix[i][i]=0;
			 for(int j=1;j<adjacency_list.get(i).size();j++) {
				 if(nodes.indexOf(adjacency_list.get(i).get(j).charAt(0)) >=0 ) {
					adjacency_matrix[i][nodes.indexOf(adjacency_list.get(i).get(j).charAt(0))]=1; 
					 
				 }
				 
				 
			 }
			 
		 }
		 
		 
		 
		 /*for(int i=0;i<adjacency_matrix.length;i++) {
			 
			 for(int j=0;j<adjacency_matrix[i].length;j++) {
				 
				 System.out.print(adjacency_matrix[i][j]+ " ");
				 
			 }
			 System.out.println();
		 }*/
		 
		 
		
	 }
	 
	 public String DFforList(String start) {
		 String tmp="";
		 sortLists1();
		 sortForMatrix();
		 
		
		 ArrayList<Boolean> visited = new ArrayList<Boolean>(); 
		 nodes="";
		 for(int i=0;i<adjacency_list.size();i++) {
			 
			 nodes+=adjacency_list.get(i).get(0);
			 
		 }
		 for (int i = 0; i < nodes.length(); i++)
             visited.add(false); 
   
         Stack<String> stack = new Stack<>(); 
           
         stack.push(start); 
           
         while(stack.empty() == false) 
         { 
             start = stack.peek(); 
             stack.pop(); 
               
             if(visited.get(nodes.indexOf(start)) == false) 
             { 
                 //System.out.print(start + " - "); 
                 tmp+=start+" - ";
            	 visited.set(nodes.indexOf(start), true); 
             } 
             
             ArrayList<String> i = adjacency_list.get(nodes.indexOf(start));
            
             int size=adjacency_list.get(nodes.indexOf(start)).size();
             int kontrol=0;
              while (kontrol<size) {  
              
            	 String v = i.get(kontrol); 
                 if(!visited.get(nodes.indexOf(v))) { 
                	 stack.push(v); 
                	 
                 }
                
                 kontrol++;
             } 
               
         }
         return tmp;
     }
	 
	 public void depthFirstSearch(String start){
		 int j;   
		 //System.out.print(start+ " - ");
		 path+=start+" - ";
		 visited[nodes.indexOf(start)]=true;
		 for(j=0;j<nodes.length();j++) {
			 
			 if(!visited[j]&&adjacency_matrix[nodes.indexOf(start)][j]==1) {
				 
				 depthFirstSearch(nodes.charAt(j)+"");
				 
			 }
			 
		 }
		 
		 
	    }
	 
	 public String DFforMatrix(String start){
		 adjacencyMatrixOlustur();
		 sortForMatrix();
		 sortLists1();
		 nodes="";
		 for(int i=0;i<adjacency_list.size();i++) {
			 
			 nodes+=adjacency_list.get(i).get(0);
			 
		 }
		 visited= new boolean[adjacency_matrix.length];
		 for(int i=0;i<visited.length;i++) {
			 visited[i]=false;
		 
		 }
		
		 depthFirstSearch(start);
		 return path;
		 
	 }	 
	 
	 
	 public String BFforMatrix(String start) { 
	  
		 adjacencyMatrixOlustur();
		 sortForMatrix();
		 sortLists();
	     String tmp="";
		 ArrayList<Boolean> visited = new ArrayList<Boolean>(); 
		 
		 nodes="";
		 for(int i=0;i<adjacency_list.size();i++) {
			 
			 nodes+=adjacency_list.get(i).get(0);
			 
		 }
		 
		 for (int i = 0; i < nodes.length(); i++)
             visited.add(false);
		 
		 
		 
		 LinkedList<String> list= new LinkedList<String>(); 
	     list.add(start); 
	   
	     visited.set(nodes.indexOf(start),true); 
	   
	     String visit; 
	     while (!list.isEmpty()) { 
	         visit = list.get(0); 
	   
	         //System.out.print(visit + " - "); 
	         tmp+=visit+" - ";
	         list.poll();
	         
	         
	         for (int i = 0; i < nodes.length(); i++) { 
	             if (adjacency_matrix[nodes.indexOf(visit)][i] == 1 && (!visited.get(i))) { 
	   
	                 list.add(nodes.charAt(i)+""); 
	   
	                 visited.set(i,true); 
	             } 
	         } 
	     } 
	     return tmp;
	 } 	 
		 
	 
	 
	 
	public String BFforList(String start){
		sortLists();
		sortForMatrix();
		String tmp="";
		boolean visited[] = new boolean[adjacency_list.size()];
	 	
        LinkedList<String> liste = new LinkedList<String>();
        
        nodes="";
		for(int i=0;i<adjacency_list.size();i++) {
			 
			 nodes+=adjacency_list.get(i).get(0);
			 
		}
		visited[nodes.indexOf(start)]=true;
        liste.add(start);
 
        while (liste.size() != 0)
        {
            start = liste.poll();
            tmp+=start+" - ";
            ArrayList<String> i =adjacency_list.get(nodes.indexOf(start));
            int size=adjacency_list.get(nodes.indexOf(start)).size();
            int kontrol=0;
            while (kontrol<size)
            {
                String n = i.get(kontrol);
                if (!visited[nodes.indexOf(n)])
                {
                    visited[nodes.indexOf(n)] = true;
                    liste.add(n);
                }
                kontrol++;
            }
        }
	 
        return tmp;
	}
  
 
	
}
