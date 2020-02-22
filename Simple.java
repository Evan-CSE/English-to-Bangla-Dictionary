
package simple;
//import SutonnyMJ Regular
import javax.swing.JFrame;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import javax.swing.border.*;

import java.awt.Dimension;

import java.awt.Toolkit;

import javax.swing.JButton;

import javax.swing.JPanel;

import java.awt.event.ActionListener;

import java.awt.event.ActionEvent;

import javax.swing.JTextField;

import java.awt.BorderLayout;

import java.io.*;

import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Simple extends JFrame

{

private Toolkit toolkit;

JTextField text1,text2;

String conversion;

public Simple()

{

int xpos;

int ypos;

Font displayFont=new Font("Times New Roman", Font.BOLD,14);

Font displayFont1=null;
    try {
        displayFont1=Font.createFont(Font.TRUETYPE_FONT,getClass().getResourceAsStream("SutonnyMJ Regular.ttf"));
    } catch (FontFormatException ex) {
        Logger.getLogger(Simple.class.getName()).log(Level.SEVERE, null, ex);
    } catch (IOException ex) {
        Logger.getLogger(Simple.class.getName()).log(Level.SEVERE, null, ex);
    }
displayFont1 = displayFont1.deriveFont(Font.PLAIN,14);
setSize(300,150);

setTitle("English To Bengali Dictionary");

setDefaultCloseOperation(EXIT_ON_CLOSE);

JPanel panel=new JPanel();

getContentPane().add(panel);

panel.setLayout(null);

toolkit=getToolkit();

Dimension size=toolkit.getScreenSize();

setLocation(size.width/2-getWidth()/2, size.height/2-getHeight()/2);

xpos=getWidth()/2;



JButton button;

text1=new JTextField();

text2=new JTextField();

button = new JButton("Translate");

button .setFont(displayFont);

text2.setFont(displayFont1);

button .setBounds(204,49,80,30);

text1.setBounds(50,20,150,30);

text2.setBounds(50,80,150,30);

button.addActionListener(

new ActionListener()

{

public void actionPerformed(ActionEvent event)

{

try

{                                                         

int count;

FileReader fr=new FileReader("reader.txt");

BufferedReader br=new BufferedReader(fr);

String s;

int linecount=0;

String line;

String words[]=new String[500];

int indexfound;

while ((s=br.readLine())!=null )

{

linecount++;

conversion = new String(text1.getText());

conversion = conversion.toLowerCase();

indexfound=s.indexOf(conversion);

if (indexfound>-1)

{


line=s;

System.out.println(line);

int idx=0;

String[] arr= line.split("=");



for (idx=0;idx<arr.length;idx++)

{

words[idx]=arr[idx];

String gg =words[idx];





if (conversion.length()==(gg.length()-1))

{



text2.setText(arr[1]);

 }}}}

 fr.close();

   }

   catch (IOException e){}

}});

panel.add(button);

panel.add(text1,BorderLayout.CENTER);

panel.add(text2,BorderLayout.WEST);

}

public static void main(String args[])

{

Simple x=new Simple();

x.setVisible(true);

}}

