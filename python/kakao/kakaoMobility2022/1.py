def solution(flowers):
    flowers.sort()

    answer = 0
    last_start = flowers[0][0]
    last_end = flowers[0][1]

    for flower in flowers:
        start,end = flower

        if start<=last_end:
            if last_end<end:
                last_end=end

        else:
            answer += (last_end - last_start)
            last_start = start
            last_end = end

    answer += (last_end - last_start)
    return answer