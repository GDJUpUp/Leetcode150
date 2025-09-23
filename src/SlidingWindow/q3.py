def max_battle_power():
    import sys

    T = int(input())
    results = []

    for _ in range(T):
        n, m, k = map(int, input().split())

        attributes = [[] for _ in range(m)]

        for _ in range(n):
            warrior_attributes = list(map(int, input().split()))
            for j in range(m):
                attributes[j].append(warrior_attributes[j])

        # Calculate the maximum total battle power
        min_power = float('inf')

        for j in range(m):
            # Sort the attributes for this property
            attributes[j].sort()
            # Get the k largest values
            max_k_values = attributes[j][-k:]
            # Calculate the minimum of the maximum k values
            min_power = min(min_power, max_k_values[-1])  # The last one is the maximum of the top k

        results.append(str(min_power))

    print("\n".join(results))


# Call the function
max_battle_power()
