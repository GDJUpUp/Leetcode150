from typing import List


class Solution:
    def canCompleteCircuit(self, gas: List[int], cost: List[int]) -> int:
        # cost = [gas[i] - cost[i] for i in range(0,len(gas))]
        cost_sum = sum(gas) - sum(cost)
        start = -1
        if cost_sum < 0:
            return start
        else:
            cost_sum = 0
            for i in range(0,len(cost)):
                if gas[i] - cost[i] >= 0 and cost_sum<=0:
                    start = i
                    cost_sum = 0
                cost_sum += gas[i] - cost[i]
            return start
if __name__ == '__main__':
    gas = [2]
    cost = [2]
    solution = Solution()
    print(solution.canCompleteCircuit(gas=gas,cost=cost))
