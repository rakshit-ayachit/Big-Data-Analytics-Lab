#!/usr/bin/python3

import sys

current_unit = None
total_salary = 0

# Input comes from standard input (stdin)
for line in sys.stdin:
    # Remove leading and trailing whitespaces
    line = line.strip()

    # Skip the header line
    if line.startswith("EmpNo,EmpName,Unit,Designation,Salary"):
        continue
    
    # Split the line into key and value
    unit, salary = line.split('\t')
    
    try:
        # Convert salary to an integer
        salary = int(salary)
    except ValueError:
        # Skip lines where salary cannot be converted to an integer
        continue
    
    # Check if the current unit is the same as the previous line
    if current_unit == unit:
        # Add the salary to the total for the current unit
        total_salary += salary
    else:
        # Output the unit and total salary for the previous unit
        if current_unit is not None:
            print(f"{current_unit}\t{total_salary}")
        
        # Update the current unit and reset the total salary
        current_unit = unit
        total_salary = salary

# Output the unit and total salary for the last unit
if current_unit is not None:
    print(f"{current_unit}\t{total_salary}")

