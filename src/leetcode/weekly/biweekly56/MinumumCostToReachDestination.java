package leetcode.weekly.biweekly56;

import java.util.LinkedList;
import java.util.Queue;

public class MinumumCostToReachDestination {
    
    class Data {
        int curCity;
        int desCity;
        int timeToTravel;
        int availableTime;
        int feePaid;
        int coveredCityCnt;
        public Data(int curCity,int desCity,int timeToTravel,int availableTime,int feePaid,int coveredCityCnt) {
            this.curCity = curCity;
            this.desCity = desCity;
            this.timeToTravel = timeToTravel;
            this.availableTime = availableTime;
            this.feePaid = feePaid;
            this.coveredCityCnt = coveredCityCnt;
        }
    }
    
public int minCost(int maxTime, int[][] edges, int[] passingFees) {
    
    int minCost = Integer.MAX_VALUE;
    
    for(int i=0;i<edges.length;i++) {
        Data data = new Data(edges[i][0],edges[i][1],edges[i][2],maxTime,0,0);
    }
    
    
        
    }
    
    public static void main(String[] args) {
        MinumumCostToReachDestination obj = new MinumumCostToReachDestination();
    }

}
