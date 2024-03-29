#!/usr/bin/python3

import sys

# Input comes from standard input (stdin)
for line in sys.stdin:
    # Remove leading and trailing whitespaces
    line = line.strip()
    
    # Split the line into fields
    fields = line.split(',')
    
    # Check if the line has the expected number of fields
    if len(fields) == 5:
        # Extract relevant information
        emp_no, emp_name, unit, designation, salary = fields
        
        # Output the unit and salary as key-value pairs, separated by a tab
        print(f"{unit}\t{salary}")

