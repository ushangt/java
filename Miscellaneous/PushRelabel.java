
package homework12;

/**
 *
 * @author Ushang-PC
 * PreFlow:
 * 1) 0 <= f(e) <= c(e)
 * 2) For all V, Sum (f(e)) incoming >= Sum (f(e)) outgoing : Preflow 
 *    Hence, flow is maximum when Sum (f(e)) incoming = Sum (f(e)) outgoing
 * 3) e f(v) = Sum (f(e)) incoming - Sum (f(e)) outgoing : Excess
 * 4) h(v) >= 0, Height of each vertex
 * 5) A s-t preflow f and labeling h are compatible if:
 *      i)   h(t) = 0
 *      ii)  h(s) = n (Number of nodes)
 *      iii) For all (v,w) in Ef (in the residual graph) h(v) <= h(w) + 1 
 * 6) If f is an s-t preflow and h is compatible with f then there is no s-t path in Gf ie residual graph
 * 7) Functions:
 *    push (f,h,v,w)
 *      if ef(v) > 0 and h(w) < h(v) and (v,w) is a residual edge      //if v has excess get rid of the excess
 *          Two cases:
 *          1.  E(v,w) is a forward edge:
 *                  df = min ( ef(v) , c(e) - f(e) )   // push out entrie excess or the amt that is there whichever is smaller
 *                  increase f(e) by df
 *          2. E(v,w) is a backward edge:
 *                  df = min ( ef(v) , f(e) )
 *                  decrease f(e) by df
 *      return (f,h)
 * 
 * 
 *    relabel(f,h,v)
 *      if ef(v) > 0 and for all (v,w) in Ef h(w) >= h(v)
 *          h(v) = h(v) + 1
 *      return (f,h)
 * 8) Algorithm:
 *      Initialize h(v) = 0 for all v != s
 *                 h(s) = n
 *                 f(e) = c(e) , for any e = (s,v)
 *                 f(e) = 0    , otherwise
 *      while there exists v != t such that ef(v) > 0      // Node has excess
 *          if there exists a w such that push(f,h,v,w) is possible
 *              push(f,h,v,w)
 *          else
 *              relabel(f,h,v)
 *      return f
 * 
 * In short any node that as excess try to do something about it. Either push ahead or behind 
 * OR
 * relabel if you cant push it anywhere
 */
public class PushRelabel {
    
  int[][] cap;

  public void init(int nodes) {
    cap = new int[nodes][nodes];
  }

  public void addEdge(int s, int t, int capacity) {
    cap[s][t] = capacity;
  }

  public int maxFlow(int s, int t) {
    int n = cap.length;
    // Intialize all heights, h
    int[] h = new int[n];
    h[s] = n - 1;

    int[] maxh = new int[n];

    int[][] f = new int[n][n];
    int[] e = new int[n];

    // Intialize the preflow and excess of every edge
    for (int i = 0; i < n; ++i) {
      f[s][i] = cap[s][i];
      f[i][s] = -f[s][i];
      e[i] = cap[s][i];
    }

    // 
    for (int sz = 0;;) {
     // Loop running for the first time 
      if (sz == 0) {
        for (int i = 0; i < n; ++i)
          if (i != s && i != t && e[i] > 0) {
            if (sz != 0 && h[i] > h[maxh[0]])
              sz = 0;
            maxh[sz++] = i;
          }
      }
      if (sz == 0)
        break;
      while (sz != 0) {             //while there exists v != t such that ef(v) > 0
        int i = maxh[sz - 1];       // Intialize i to maximum of h 
        boolean pushed = false;     // Its is not pushed yet
        // go through all the nodes
        for (int j = 0; j < n && e[i] != 0; ++j) {
          if (h[i] == h[j] + 1 && cap[i][j] - f[i][j] > 0) { //if ef(v) > 0 and h(w) < h(v) and (v,w) is a residual edge 
            int df = Math.min(cap[i][j] - f[i][j], e[i]);       // (v,w) is a residual edge
            f[i][j] += df;
            f[j][i] -= df;
            e[i] -= df;
            e[j] += df;
            if (e[i] == 0)
              --sz;
            pushed = true;                                  // mark as pushed
          }
        }
        if (!pushed) {                                      // Relabel operation since it can't be pushed
          h[i] = Integer.MAX_VALUE;
          for (int j = 0; j < n; ++j)
            if (h[i] > h[j] + 1 && cap[i][j] - f[i][j] > 0)  //if ef(v) > 0 and for all (v,w) in Ef h(w) >= h(v)
              h[i] = h[j] + 1;
          if (h[i] > h[maxh[0]]) {
            sz = 0;
            break;
          }
        }
      }
    }

    int flow = 0;
    for (int i = 0; i < n; i++)
      flow += f[s][i];

    return flow;
  }

  
  public static void main(String[] args) {
    int[][] capacity = { { 0, 3, 2 }, { 0, 0, 2 }, { 0, 0, 0 } };
    int n = capacity.length;
    PushRelabel flow = new PushRelabel();
    flow.init(n);
    for (int i = 0; i < n; i++)
      for (int j = 0; j < n; j++)
        if (capacity[i][j] != 0)
          flow.addEdge(i, j, capacity[i][j]);
    System.out.println("Maximum flow is: " + flow.maxFlow(0, 2));
  }
    
}
