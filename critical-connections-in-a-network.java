class Solution {
    
    public class Graph {
        public ArrayList<Node> g;
        
        public Graph(int n) {
            g = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                g.add(new Node(i));
            }
        }
        
        public void addEdge(int val1, int val2) {
            g.get(val1).nodes.add(g.get(val2));
            g.get(val2).nodes.add(g.get(val1));
        }
        
        public boolean dfs(Node n, Stack<Node> s) {
            helper(n, s);
            for (int i = 0; i < g.size(); i++) {
                if (g.get(i).mark) {
                    return false;
                }
            }
            return true;
            
        }
        
        public void helper(Node n, Stack<Node> s) {
            for (int i = 0; i < n.nodes.size(); i++) {
                s.push(n.nodes.get(i));
            }
            
            while (!s.empty()) {
                Node nod = s.pop();
                if (nod.mark) {
                    nod.mark = false;
                    dfs(nod, s);
                }
            }
        }
        
        public void deleteEdge(int val1, int val2) {
            
            for (int i = 0; i < g.get(val1).nodes.size(); i++) {
                if (g.get(val1).nodes.get(i).val == val2) {
                    g.get(val1).nodes.remove(i);
                }
            }
            
            for (int i = 0; i < g.get(val2).nodes.size(); i++) {
                if (g.get(val2).nodes.get(i).val == val1) {
                    g.get(val2).nodes.remove(i);
                }
            }
            
        }
        
        public void reset() {
            for (int i = 0; i < g.size(); i++) {
                g.get(i).mark = true;
            }
        }
    }
    
    public class Node {
        
        public int val;
        public boolean mark = true;
        public ArrayList<Node> nodes;
        public Node(int n) {
            val = n;
            nodes = new ArrayList<>();
            
        }
        
    }
    
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        
        ArrayList<List<Integer>> arr = new ArrayList<>();
        
        Graph g = new Graph(n);
        for (int i = 0; i < connections.size(); i++) {
    
            int one = connections.get(i).get(0);
            int two = connections.get(i).get(1);

            g.addEdge(one, two);
        }
        
        for (int skip = 0; skip < connections.size(); skip++) {
            int one = connections.get(skip).get(0);
            int two = connections.get(skip).get(1);
            g.deleteEdge(one, two);
            
            if (!g.dfs(g.g.get(0), new Stack<Node>())) {
                arr.add(connections.get(skip));
            }
            
            g.addEdge(one, two);
            g.reset();
        }
        
        return arr;
    }
}
