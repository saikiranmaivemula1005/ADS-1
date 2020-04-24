
import wx

# Declare GUI Constants
MENU_FILE_EXIT = wx.NewId()
DRAG_SOURCE    = wx.NewId()
# BUTTONID = wx.NewId()

class TextDropTarget(wx.TextDropTarget):
   """ This object implements Drop Target functionality for Text """
   def __init__(self, obj):
      """ Initialize the Drop Target, passing in the Object Reference to
          indicate what should receive the dropped text """
      # Initialize the wx.TextDropTarget Object
      wx.TextDropTarget.__init__(self)
      # Store the Object Reference for dropped text
      self.obj = obj

   def OnDropText(self, x, y, data):
      """ Implement Text Drop """
      # When text is dropped, write it into the object specified
      self.obj.WriteText(data + '\n\n')


class MainWindow(wx.Frame):
   """ This window displays the GUI Widgets. """
   def __init__(self,parent,id,title):
       wx.Frame.__init__(self,parent, wx.ID_ANY, title, size = (1200,600), style=wx.DEFAULT_FRAME_STYLE|wx.NO_FULL_REPAINT_ON_RESIZE)
       self.SetBackgroundColour(wx.WHITE)
       menuBar = wx.MenuBar()
       # Build a Menu Object to go into the Menu Bar
       menu1 = wx.Menu()
       menu1.Append(MENU_FILE_EXIT, "E&xit", "Quit Application")
       # Place the Menu Item in the Menu Bar
       menuBar.Append(menu1, "&File")
       # Place the Menu Bar on the ap
       self.SetMenuBar(menuBar)
       #Define Events for the Menu Items
       wx.EVT_MENU(self, MENU_FILE_EXIT, self.CloseWindow)

       wx.StaticText(self, -1, "Text Drag Source  (left-click to select, right-click to drag)", (10, 1))
       # Create a Text Control
       self.text = wx.TextCtrl(self, DRAG_SOURCE, "", pos=(10,15), size=(350,500), style = wx.TE_MULTILINE|wx.HSCROLL|wx.TE_READONLY)
       # Make this control a Text Drop Target
       # Create a Text Drop Target object
       dt1 = TextDropTarget(self.text)
       # Link the Drop Target Object to the Text Control
       self.text.SetDropTarget(dt1)

       # Put some text in the control as a starting place to have something to copy
       self.text.WriteText("Tirupati is a temple of Venkateswara (Vishnu), located in Chittoor District, AP, India.\nThe temple is believed to be constructed around 300 AD.\nThe temple is managed by Tirumala Tirupati Devasthanams(TTD).\nThe local language is Telugu.\nFind more information in the official website www.tirumala.org ")
       # for x in range(20):
       #    self.text.WriteText("This is line %d of some text to drag.\n" % x)

       wx.EVT_RIGHT_DOWN(self.text, self.OnDragInit)

       # Define a Text Control to recieve Dropped Text
       # Label the control
       wx.StaticText(self, -1, "Text Drop Target", (370, 1))
       # Create a read-only Text Control
       self.text2 = wx.TextCtrl(self, -1, "", pos=(370,15), size=(410,470), style = wx.TE_MULTILINE|wx.HSCROLL)
       # Make this control a Text Drop Target
       # Create a Text Drop Target object
       dt2 = TextDropTarget(self.text2)
       # Link the Drop Target Object to the Text Control
       self.text2.SetDropTarget(dt2)
       # self.panel = wx.Panel(self, wx.ID_ANY, pos=(400,15))
       self.button = wx.Button(self, wx.ID_ANY, pos=(680,490), label="Compare")
        # Set event handlers
       self.button.Bind(wx.EVT_BUTTON, self.OnButton)

       wx.StaticText(self, -1, "Text Drag Source  (left-click to select, right-click to drag)", (10, 1))
       # Create a Text Control
       self.text3 = wx.TextCtrl(self, DRAG_SOURCE, "", pos=(800,15), size=(350,500), style = wx.TE_MULTILINE|wx.HSCROLL|wx.TE_READONLY)

       # Display the Window
       self.Show(True)



   def OnButton(self, e):
       self.text3.WriteText(self.text2.GetValue())



   def CloseWindow(self, event):
       """ Close the Window """
       self.Close()

   def OnDragInit(self, event):
       """ Begin a Drag Operation """
       # Create a Text Data Object, which holds the text that is to be dragged
       tdo = wx.PyTextDataObject(self.text.GetStringSelection())
       # Create a Drop Source Object, which enables the Drag operation
       tds = wx.DropSource(self.text)
       # Associate the Data to be dragged with the Drop Source Object
       tds.SetData(tdo)
       # Initiate the Drag Operation
       tds.DoDragDrop(True)



class MyApp(wx.App):
   """ Define the Drag and Drop Example Application """
   def OnInit(self):
      """ Initialize the Application """
      # Declare the Main Application Window
      frame = MainWindow(None, -1, "Telugu Wiki")
      # Show the Application as the top window
      self.SetTopWindow(frame)
      return True


# Declare the Application and start the Main Loop
app = MyApp(0)
app.MainLoop()