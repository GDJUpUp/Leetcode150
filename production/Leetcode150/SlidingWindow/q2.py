def find_kth_smallest_in_intervals():
    import heapq
    # 读取输入
    n, k = map(int, input().split())
    a = list(map(int, input().split()))

    result = []
    min_heap = []

    for i in range(n):
        # 添加当前元素到堆中
        heapq.heappush(min_heap, a[i])

        # 如果当前堆的大小小于 k，返回 -1
        if len(min_heap) < k:
            result.append(-1)
        else:
            # 找到第 k 小的元素
            # 复制一份并排序，取出第 k 小元素
            # 注意：这里我们要在堆中找到第 k 小的数
            # 这里不需要完全排序，直接用 n-k 的方法
            # 将元素存入临时堆中
            temp_heap = list(min_heap)
            temp_kth_smallest = heapq.nsmallest(k, temp_heap)[-1]  # 取出第 k 小的数
            result.append(temp_kth_smallest)

    print(' '.join(map(str, result)))

# 调用函数
find_kth_smallest_in_intervals()