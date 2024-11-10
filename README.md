# JavaAssigment2
VN Java Assigment 2

Document for assignment [Link](https://docs.google.com/document/d/1lWG-y15eEBhXUx0kjKqvvQm478fNzhrppVKCyQbBtXU/edit?usp=sharing).

# Test Data

### Course Students (C):
- John Doe (ID: 12345) has marks that should yield a Distinction (D).
- Jane Smith (ID: 12346) has marks that should yield a Credit (C).
- Alex Johnson (ID: 12347) has marks that should yield a Fail (N).
- Emily Brown (ID: 12348) has marks that should yield a High Distinction (HD).
- Michael Lee (ID: 12349) has marks that should yield a Credit (C).

### Research Students (R):
- Lisa Wong (ID: 12350) has marks that should yield a High Distinction (HD).
- Tom Clark (ID: 12351) has marks that should yield a Pass (P).
- Sara White (ID: 12352) has marks that should yield a Credit (C).
- David Moore (ID: 12353) has marks that should yield a Distinction (D).
- Alice Green (ID: 12354) has marks that should yield a High Distinction (HD).

# Expected Results for Each Menu Option
### Load Data from CSV
**Expected Result**: All 10 students (5 course work and 5 research) should load correctly.

### Remove Student by ID
**Test Case**: Remove student with ID 12347 (Alex Johnson). Expected Result: Confirmation prompt with name and ID. After confirmation, Alex Johnson’s record should be removed from the list.

### Display All Students
**Expected Result**: All student details currently held in the ArrayList should print, showing the loaded students and any modifications (e.g., after removals).

### Analyze Coursework Marks
**Calculation Details**:

- Calculate the average mark for course work students.
- Based on test data:
- Average Overall Mark (approximation): ~71.4 (depending on actual calculation).
- Expected Result:
- Above average: 3 students (John Doe, Emily Brown, Michael Lee).
- Below average: 2 students (Jane Smith, Alex Johnson).
- Report Grade by Student ID
- Test Case: Enter ID 12345 (John Doe).
- Expected Result: Display John Doe’s grade report with overall mark and grade (Distinction).

### Sort Students by ID
**Expected Result**: The list should sort in ascending order by student ID using insertion sort. After sorting:

- First student in list: John Doe (ID: 12345).
- Last student in list: Alice Green (ID: 12354).
- Save Sorted List to CSV
- Expected Result: A CSV file, sorted_students.csv, is created with sorted entries:

**Format**: First entry should be John Doe (ID: 12345), last entry should be Alice Green (ID: 12354).

# Limitations

### Limited Data Validation
The program doesn’t validate the CSV data format or individual values (e.g., negative marks or non-numeric IDs). Any malformed or incorrect data could cause the program to fail or produce inaccurate results.


### Hard-Coded Assumptions in CSV Parsing
The CSV parsing assumes a specific format and structure, which limits flexibility. For example, it assumes the exact order and number of fields for each student type (C or R).

### Single Responsibility Violations
**Limitation**: Some classes perform multiple tasks (e.g., the Student_Course class both stores student data and computes grades). This can make the code harder to maintain and extend, as it mixes data storage with business logic.
**Enhancement**: Use separate classes for data (like Student_Course) and operations (like calculating grades). This separation would simplify updates to either aspect independently.

### Efficiency of Sorting Method
The insertion sort algorithm used for sorting students by ID has a time complexity of
𝑂
(
𝑛
2
)
O(n
2
). This is inefficient for large datasets and will perform poorly as the number of students increases.