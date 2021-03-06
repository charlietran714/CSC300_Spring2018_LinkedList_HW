package com.example.awesomefat.csc300_spring2018_linkedlist;

import android.content.Context;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by awesomefat on 1/30/18.
 */

public class LinkedList
{
    private Node head;
    private ViewGroup linkedListContainer;
    private Context theContext;
    private int numElements;

    public LinkedList(ViewGroup linkedListContainer, Context theContext)
    {
        this.head = null;
        this.linkedListContainer = linkedListContainer;
        this.theContext = theContext;
        this.numElements = 0;
    }


    public int removeFront()
    {
        //removes the front of the linked list, and updates the interface
        //and ultimately returns the int payload of the node that was removed.
        this.linkedListContainer.removeViewAt(0); // removes the view at 0
        Node currNode = this.head;
        this.head = head.getNextNode();
        currNode.setNextNode(null);
        this.numElements--;
        return currNode.getPayload();

    }

    public int removeEnd()
    {
        //removes the end of the linked list, and updates the interface
        //and ultimately returns the int payload of the node that was removed.
        this.linkedListContainer.removeViewAt(numElements - 1 );
        Node currNode = this.head;

        while(currNode.getNextNode() != null)
        {
            currNode = currNode.getNextNode();
        }
        //currnode is sitting at the last node
        currNode.setNextNode(null);

        return 0;



    }

    public void addFront(int payload)
    {
        Node n = new Node(payload);

        //add to front of list
        if(this.head == null)
        {
            this.head = n;
            this.numElements++;
        }
        else
        {
            //not dealing with the empty list
            n.setNextNode(this.head);
            this.head = n;
            this.numElements++;
        }

        //update the interface
        TextView tv = new TextView(this.theContext);
        tv.setText("" + payload);
        tv.setGravity(Gravity.CENTER);
        this.linkedListContainer.addView(tv,0);
    }

    public void addEnd(int payload)
    {
        if(this.head == null)
        {
            this.addFront(payload);
            this.numElements++;
        }
        else
        {
            this.head.addEnd(payload);
            this.numElements++;
            /*
            Node n = new Node(payload);
            Node currNode = this.head;

            while(currNode.getNextNode() != null)
            {
                currNode = currNode.getNextNode();
            }
            //currnode is sitting at the last node
            currNode.setNextNode(n);
            */

            //update the interface
            TextView tv = new TextView(this.theContext);
            tv.setText("" + payload);
            tv.setGravity(Gravity.CENTER);
            this.linkedListContainer.addView(tv);
        }
    }

    public void display()
    {
        if(this.head == null)
        {
            System.out.println("Empty List");
        }
        else
        {
            //do stuff here
            this.head.display();
            System.out.println("");
            /*
            String answer = "";
            Node currNode = this.head;
            while(currNode != null)
            {
                answer = answer + currNode.getPayload() + " -> ";
                currNode = currNode.getNextNode();
            }
            System.out.println(answer);
            */

        }
    }
}
