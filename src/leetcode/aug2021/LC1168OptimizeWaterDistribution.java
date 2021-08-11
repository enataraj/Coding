package leetcode.aug2021;

public class LC1168OptimizeWaterDistribution {

    /*
     * 
     * 
     * def minCostToSupplyWater(self, n: int, wells: List[int], pipes: List[List[int]]) -> int:
        
        graph = defaultdict(list)
        heap = []
        
        for i in range(1,n+1):
            graph[0].append((i,wells[i-1]))
            heap.append([wells[i-1], i])
        
        for i,pipe in enumerate(pipes):
            graph[pipe[0]].append((pipe[1],pipe[2]))
            graph[pipe[1]].append((pipe[0],pipe[2]))
        
        total_cost = 0
        
        heapq.heapify(heap)
        visited = set()
        
        while heap:
            cost,house = heapq.heappop(heap)
            if house in visited:
                continue
            total_cost += cost
            visited.add(house)
            if len(visited) == n:
                break
            for ngh,cost in graph[house]:
                if ngh not in visited:
                    heapq.heappush(heap,[cost,ngh])
                    
        return total_cost
            
   
     */
}
