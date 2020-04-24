# from tkinter import *

# m1 = PanedWindow()
# m1.pack(fill = BOTH, expand = 2)

# left = Entry(m1, bd = 5)
# m1.add(left)

# right = Entry(m1, bd = 5)
# m1.add(right)

# # m2 = PanedWindow(m1, orient = VERTICAL)
# # m1.add(m2)

# # top = Scale( m2, orient = HORIZONTAL)
# # m2.add(top)

# # bottom = Button(m2, text = "OK")
# # m2.add(bottom)

# mainloop()



# import tkinter as tk

# root = tk.Tk()

# left_frame = tk.Frame(root, bg = 'yellow')
# left_frame.pack(side = tk.LEFT, expand = True, fill = tk.BOTH)

# right_frame = tk.Frame(root, bg = 'lime')
# right_frame.pack(side = tk.LEFT, expand = True, fill = tk.BOTH)

# root.mainloop()

# from tkinter import *

# m = PanedWindow(orient=HORIZONTAL)
# m.pack(fill=BOTH, expand=1)

# top = Label(m, text="top pane")
# m.add(top)

# bottom = Label(m, text="bottom pane")
# m.add(bottom)

# mainloop()

from tkinter import *
# # import messagebox
import tkinter

top = Tk()

Lb1 = Listbox(top)
Lb1.insert(1, "Python")
Lb1.insert(2, "Perl")
Lb1.insert(3, "C")
Lb1.insert(4, "PHP")
Lb1.insert(5, "JSP")
Lb1.insert(6, "Ruby")

Lb1.pack()
top.mainloop()
# 

# from tkinter import *
# class DragManager():
#     def add_dragable(self, widget):
#         widget.bind("<ButtonPress-1>", self.on_start)
#         widget.bind("<B1-Motion>", self.on_drag)
#         widget.bind("<ButtonRelease-1>", self.on_drop)
#         widget.configure(cursor="hand1")

#     def on_start(self, event):
#         # you could use this method to create a floating window
#         # that represents what is being dragged.
#         pass

#     def on_drag(self, event):
#         # you could use this method to move a floating window that
#         # represents what you're dragging
#         pass

#     def on_drop(self, event):
#         # find the widget under the cursor
#         x,y = event.widget.winfo_pointerxy()
#         target = event.widget.winfo_containing(x,y)
#         try:
#             target.configure(image=event.widget.cget("image"))
#         except:
#             pass