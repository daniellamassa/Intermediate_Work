def sort2(List):
    sortSteps = 0
    data = []
    for item in List:
        data.append(item)
        sortSteps += 2
    else:
        swapped = True
        while swapped:
            swapped = False
            for i in range(0, len(data) - 1):
                sortSteps += 2
                if data[i] > data[(i + 1)]:
                    temp = data[i]
                    data[i] = data[(i + 1)]
                    data[i + 1] = temp
                    swapped = True
                    sortSteps += 4

        for k in range(sortSteps, 30000000 - 2 * len(List)):
            temp = data[0]
            sortSteps += 1
        else:
            return (
             data, sortSteps)

qSteps = 0

def sort1(List):
    global qSteps
    qSteps = 0
    data = []
    for item in List:
        data.append(item)
        qSteps += 2
    else:
        __sort1_util(data, 0, len(data) - 1)
        return (data, qSteps)


def __sort1_util(data, start, end):
    global qSteps
    pivot = data[start]
    qSteps += 1
    i = start
    j = end
    while i <= j:
        if data[i] < pivot:
            i += 1
            qSteps += 1
        elif pivot < data[j]:
            j -= 1
            qSteps += 1
        elif i <= j:
            temp = data[i]
            data[i] = data[j]
            data[j] = temp
            qSteps += 4
            i += 1
            j -= 1

    if start < j:
        __sort1_util(data, start, j)
    if i < end:
        __sort1_util(data, i, end)
