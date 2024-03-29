#!/usr/bin/python3

import sys

current_year = None
total_temperature = 0
count = 0
min_temperature = float('inf')
max_temperature = float('-inf')

for line in sys.stdin:
    key, value = line.strip().split('\t')
    year = key
    temperature = int(value)

    if current_year is None:
        current_year = year

    if current_year == year:
        total_temperature += temperature
        count += 1
        min_temperature = min(min_temperature, temperature)
        max_temperature = max(max_temperature, temperature)
    else:
        average_temperature = total_temperature / count
        print(f'{current_year}\t{average_temperature}\t{min_temperature}\t{max_temperature}')

        # Reset variables for the new year
        current_year = year
        total_temperature = temperature
        count = 1
        min_temperature = temperature
        max_temperature = temperature

# Print the last year's result
if current_year:
    average_temperature = total_temperature / count
    print(f'{current_year}\t{average_temperature}\t{min_temperature}\t{max_temperature}')

