import socket
import threading
s = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
port=5000
ip="10.10.9.103"
s.connect((ip, port))
print("enter roll number")
rollnumber = input()
s.send(rollnumber.encode())
clientRunning = True


def recieveMessage(sock):
    serverDown = False
    while clientRunning and (not serverDown):
        question = s.recv(1024).decode()
        print(question)
        # print("give answer")
        student_answer = str(input())
        s.send(student_answer.encode())
        serverDown = True
threading.Thread(target = recieveMessage, args = (s, )).start()

    

