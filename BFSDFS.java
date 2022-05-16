 
import java.util.*;
 
public class Asgn_1{
    
    static class Graph{
        int V; 
        LinkedList<Integer>[] adj; 
       
        Graph(int V){
            this.V = V;
            adj = new LinkedList[V];
             
            for (int i = 0; i < adj.length; i++){
                 adj[i] = new LinkedList<Integer>();
            }
               
             
        }
         
        void addEdge(int v, int w){
            adj[v].add(w);
            
            adj[w].add(v);
            
        }
         
        
        void DFS(int s){
            
            Vector<Boolean> visited = new Vector<Boolean>(V);
            for (int i = 0; i < V; i++)
                visited.add(false);
     
           
            Stack<Integer> stack = new Stack<>();
             
            
            stack.push(s);
             
            while(stack.empty() == false){
                
                s = stack.peek();
                stack.pop();
                
                if(visited.get(s) == false)
                {
                    System.out.print(s + " ");
                    visited.set(s, true);
                }
                 
                
                Iterator<Integer> itr = adj[s].iterator();
                 
                while (itr.hasNext())
                {
                    int v = itr.next();
                    if(!visited.get(v))
                        stack.push(v);
                }
                 
            }
        }
        void BFS(int s){
        
        boolean visited[] = new boolean[V];
        LinkedList<Integer> queue = new LinkedList<Integer>();
 
        
        visited[s]=true;
        queue.add(s);
 
        while (queue.size() != 0)
        {
            
            s = queue.poll();
            System.out.print(s+" ");
 
            
            Iterator<Integer> i = adj[s].listIterator();
            while (i.hasNext())
            {
                int n = i.next();
                if (!visited[n])
                {
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }
    }
    }
    
    public static void main(String[] args)
    {
        
        Graph gr = new Graph(7);
        gr.addEdge(0, 1);
        gr.addEdge(0, 2);
        gr.addEdge(0, 3);
        gr.addEdge(3, 6);
        gr.addEdge(2, 5);
        gr.addEdge(2, 4);
        System.out.println("Depth First Traversal:");
        gr.DFS(5);
        System.out.println();
        System.out.println("Breadth First Traversal:");
        gr.BFS(5);
        System.out.println();
    }
}