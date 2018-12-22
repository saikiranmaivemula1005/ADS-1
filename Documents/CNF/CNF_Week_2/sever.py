import socket
import threading
import csv

s=socket.socket()
ip="10.10.9.103"
port=5000
list_of_students=[]
list_of_questions = []
list_of_answers = []
s.bind((ip,port))
s.listen()
serverRunning = True


with open('data.csv', mode='r') as csv_file:
    csv_reader = csv.reader(csv_file, delimiter=',')
    for row in csv_reader:
            list_of_students.append(row[0])
            list_of_questions.append(row[1])
            list_of_answers.append(row[2])
while serverRunning:
    client,address = s.accept()
    rollnumber = client.recv(1024).decode()
    if rollnumber in list_of_students:
        identity = list_of_students.index(rollnumber)
        client.send((list_of_questions[identity]).encode())
        student_answer = client.recv(1024).decode()
        answer = list_of_answers[identity]
        if student_answer == answer:
            print("ATTENDANCE SUCCESS")
            print("connection closed")
            serverRunning = False
        else:
            print("ATTENDANCE FAILURE")
            serverRunning = False
            # client.send((list_of_questions[identity]).encode())
    else:
        client.send(("ROLLNUMBER-NOTFOUND").encode())


    


