# s="2021:04:12:16:08:35"
# times=["01:06:30:00","01:04:12:00"]
# s="2021:04:12:16:08:35"
# times= ["01:06:30:00", "00:01:12:00"]
"2021:01:30:23:59:59", ["30:23:59:59"]
s="2021:01:30:23:59:59"
times= ["30:23:59:59"]




def add_time(now, time):
    success=False

    year, month, day, hour, minute, second = map(int, now.split(":"))
    d,h,m,s = map(int, time.split(":"))

    now_month=month
    
    next_second= second + s
    if next_second >= 60:
        m += next_second // 60
        next_second %= 60

    next_minute= minute + m
    if next_minute >= 60:
        h += next_minute // 60
        next_minute %= 60
    
    next_hour= hour + h
    if next_hour >= 24:
        d += next_hour // 24
        next_hour %= 24

    next_day= day + d
    if next_day > 30:
        month += next_day // 30
        next_day %= 30 
    
    next_month = month
    if next_month > 12:
        year += next_month // 12
        next_month %= 12 

    next_year=year

    if (next_month==now_month and 0<= next_day - day <= 1)  or (next_month==(now_month+1)%12 and day==30 and next_day == 1):
        success=True

    return success, ":".join(map(str,[next_year, next_month, next_day, next_hour, next_minute, next_second]))


def calculate_period(start, end):
    year1, month1, day1 = map(int, start.split(":")[0:3])
    year2, month2, day2 = map(int, end.split(":")[0:3])

    return (year2-year1)*360 + (month2-month1)*30 + (day2-day1) + 1


def solution(s, times):
    
    success = 1

    first_saving=s
    now=s

    for time in times:
        is_success, now = add_time(now, time)
        print(now)
        if not is_success:
            success = 0

    saving_period=calculate_period(first_saving, now)

    return [success, saving_period]

print(solution(s,times))