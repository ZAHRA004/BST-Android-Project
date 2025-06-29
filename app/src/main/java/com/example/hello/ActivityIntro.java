package com.example.hello;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import org.w3c.dom.Node;

import java.lang.reflect.Array;
import java.util.Timer;
import java.util.TimerTask;
import java.text.*;
import java.util.concurrent.TimeUnit;


public class ActivityIntro extends AppCompatActivity {

    EditText input;//Get number variable
    Button btn_add, back, exit;
    ImageView c1, c2, c3, c4, c5, c6, c7;//Tree circle variables
    ImageView c1l, c1r, c2l, c2r, c3l, c3r;//Tree arrow variables
    TextView textc1, textc2, textc3, textc4, textc5, textc6, textc7;//Text variables inside the tree
    ImageView c1b, c2b, c3b, c4b, c5b, c6b, c7b;//Tree circle variables for postorder
    TextView result;//Show postorder variables
    int left_n , right_n;//Number of nodes 2 and 3 trees
    public static int[] saveData = new int[8];//Variables inside the tree
    public static int circle_num=0 ;//Postorder contoroler

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        BST bst = new BST();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Tree circle variables
        c1 = findViewById(R.id.c1);
        c2 = findViewById(R.id.c2);
        c3 = findViewById(R.id.c3);
        c4 = findViewById(R.id.c4);
        c5 = findViewById(R.id.c5);
        c6 = findViewById(R.id.c6);
        c7 = findViewById(R.id.c7);

        //Tree arrow variables
        c1l = findViewById(R.id.c1l);
        c1r = findViewById(R.id.c1r);
        c2l = findViewById(R.id.c2l);
        c2r = findViewById(R.id.c2r);
        c3l = findViewById(R.id.c3l);
        c3r = findViewById(R.id.c3r);

        //Text variables inside the tree
        textc1 = findViewById(R.id.textc1);
        textc2 = findViewById(R.id.textc2);
        textc3 = findViewById(R.id.textc3);
        textc4 = findViewById(R.id.textc4);
        textc5 = findViewById(R.id.textc5);
        textc6 = findViewById(R.id.textc6);
        textc7 = findViewById(R.id.textc7);

        result = findViewById((R.id.result));

        //Tree circle variables for postorder
        c1b = findViewById(R.id.c1b);
        c2b = findViewById(R.id.c2b);
        c3b = findViewById(R.id.c3b);
        c4b = findViewById(R.id.c4b);
        c5b = findViewById(R.id.c5b);
        c6b = findViewById(R.id.c6b);
        c7b = findViewById(R.id.c7b);


        c1.setVisibility(View.INVISIBLE);
        c2.setVisibility(View.INVISIBLE);
        c3.setVisibility(View.INVISIBLE);
        c4.setVisibility(View.INVISIBLE);
        c5.setVisibility(View.INVISIBLE);
        c6.setVisibility(View.INVISIBLE);
        c7.setVisibility(View.INVISIBLE);


        c1l.setVisibility(View.INVISIBLE);
        c1r.setVisibility(View.INVISIBLE);
        c2l.setVisibility(View.INVISIBLE);
        c2r.setVisibility(View.INVISIBLE);
        c3l.setVisibility(View.INVISIBLE);
        c3r.setVisibility(View.INVISIBLE);


        textc1.setVisibility(View.INVISIBLE);
        textc2.setVisibility(View.INVISIBLE);
        textc3.setVisibility(View.INVISIBLE);
        textc4.setVisibility(View.INVISIBLE);
        textc5.setVisibility(View.INVISIBLE);
        textc6.setVisibility(View.INVISIBLE);
        textc7.setVisibility(View.INVISIBLE);


        c1b.setVisibility(View.INVISIBLE);
        c2b.setVisibility(View.INVISIBLE);
        c3b.setVisibility(View.INVISIBLE);
        c4b.setVisibility(View.INVISIBLE);
        c5b.setVisibility(View.INVISIBLE);
        c6b.setVisibility(View.INVISIBLE);
        c7b.setVisibility(View.INVISIBLE);

        input = (EditText) findViewById(R.id.input);
        btn_add = (Button) findViewById(R.id.btn_add);
        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int i = Integer.valueOf(input.getText().toString());
                bst.insert(i);
            }
        });

        back = (Button) findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                result();
            }
        });

        exit = (Button) findViewById(R.id.exit);
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                System.exit(0);
            }
        });

    }

    // A class to represent a node of a BST
    class Node {
        int value; // The value of the node
        Node left; // The left child of the node
        Node right; // The right child of the node

        // A constructor to create a new node with a given value
        public Node(int value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }

    // A class to represent a BST
    public class BST {
        Node root; // The root node of the BST

        // A constructor to create an empty BST
        public BST() {
            this.root = null;
        }

        // A method to insert a new value into the BST
        public void insert(int value) {
            // If the BST is empty, make the new value the root
            if (this.root == null) {
                this.root = new Node(value);
                c1.setVisibility(View.VISIBLE);
                textc1.setText((String.valueOf(value)));
                textc1.setVisibility(View.VISIBLE);
                saveData[0] = value;
                saveData[7] = 1;
                return;
            } else {
                // Otherwise, call the recursive helper method to insert the value
                insertHelper(this.root, value);
            }
        }

        // A helper method to insert a new value into the BST recursively
        private void insertHelper(Node node, int value) {
            // If the value is less than the node's value, go to the left subtree
            if (value < node.value) {
                // If the left child is null, make the new value the left child
                if (node.left == null) {
                    node.left = new Node(value);
                    c2.setVisibility(View.VISIBLE);
                    textc2.setText((String.valueOf(value)));
                    textc2.setVisibility(View.VISIBLE);
                    c1l.setVisibility(View.VISIBLE);
                    left_n = value;
                    saveData[1]=value;
                   return;
                } else {
                    // Otherwise, recurse on the left child
                    if(left_n>value)
                    {
                        c4.setVisibility(View.VISIBLE);
                        textc4.setText((String.valueOf(value)));
                        textc4.setVisibility(View.VISIBLE);
                        c2l.setVisibility(View.VISIBLE);
                        saveData[3]=value;
                        return;
                    }
                    if(left_n==value)
                    {
                        return;
                        // If the value is equal to the node's value, do nothing
                    }
                    else
                    {
                        c5.setVisibility(View.VISIBLE);
                        textc5.setText((String.valueOf(value)));
                        textc5.setVisibility(View.VISIBLE);
                        c2r.setVisibility(View.VISIBLE);
                        saveData[4]=value;
                        return;
                    }
                }
            } else if (value > node.value) {
                // If the value is greater than the node's value, go to the right subtree
                // If the right child is null, make the new value the right child
                if (node.right == null) {
                    node.right = new Node(value);
                    c3.setVisibility(View.VISIBLE);
                    textc3.setText((String.valueOf(value)));
                    textc3.setVisibility(View.VISIBLE);
                    c1r.setVisibility(View.VISIBLE);
                    saveData[2]=value;
                    right_n = value;
                    return;
                } else {
                    // Otherwise, recurse on the right child
                    if(right_n>value)
                    {
                        c6.setVisibility(View.VISIBLE);
                        textc6.setText((String.valueOf(value)));
                        textc6.setVisibility(View.VISIBLE);
                        c3l.setVisibility(View.VISIBLE);
                        saveData[5]=value;
                        return;
                    }
                    if(right_n==value)
                    {
                        return;
                        // If the value is equal to the node's value, do nothing
                    }
                    else
                    {
                        c7.setVisibility(View.VISIBLE);
                        textc7.setText((String.valueOf(value)));
                        textc7.setVisibility(View.VISIBLE);
                        c3r.setVisibility(View.VISIBLE);
                        saveData[6]=value;
                        return;
                    }
                }
            } else {
                // If the value is equal to the node's value, do nothing
                // (Assuming no duplicates are allowed in the BST)
            }
        }
    }

    public void traversepostorder(Node n)
    {
        if(n == null)
        {
            return;
        }
        traversepostorder(n.left);
        traversepostorder(n.right);
        System.out.print(n.value + " ");
    }

    static int i=0;//Temp contoroler
    public void result()
    {
        int[] temp = {3,4,1,5,6,2,0,7};
        if(saveData[temp[i]] > 0)
        {
            switch (temp[i])
            {
                case 3:
                {
                    circle_num=4;
                    textc4.setTextColor(Color.WHITE);
                    textc4.setTypeface(null,Typeface.BOLD);
                    c4.setVisibility(View.INVISIBLE);
                    c4b.setVisibility(View.VISIBLE);
                    break;
                }
                case 4:
                {
                    if(circle_num==4)
                    {
                        textc4.setTextColor(Color.BLACK);
                        textc4.setTypeface(null,Typeface.NORMAL);
                        c4b.setVisibility(View.INVISIBLE);
                        c4.setVisibility(View.VISIBLE);
                    }
                    circle_num=5;
                    textc5.setTextColor(Color.WHITE);
                    textc5.setTypeface(null,Typeface.BOLD);
                    c5.setVisibility(View.INVISIBLE);
                    c5b.setVisibility(View.VISIBLE);
                    break;
                }
                case 1:
                {
                    if(circle_num==4)
                    {
                        textc4.setTextColor(Color.BLACK);
                        textc4.setTypeface(null,Typeface.NORMAL);
                        c4b.setVisibility(View.INVISIBLE);
                        c4.setVisibility(View.VISIBLE);
                    }
                    if(circle_num==5)
                    {
                        textc5.setTextColor(Color.BLACK);
                        textc5.setTypeface(null,Typeface.NORMAL);
                        c5b.setVisibility(View.INVISIBLE);
                        c5.setVisibility(View.VISIBLE);
                    }
                    circle_num=2;
                    textc2.setTextColor(Color.WHITE);
                    textc2.setTypeface(null,Typeface.BOLD);
                    c2.setVisibility(View.INVISIBLE);
                    c2b.setVisibility(View.VISIBLE);
                    break;
                }
                case 5:
                {
                    if(circle_num==2)
                    {
                        textc2.setTextColor(Color.BLACK);
                        textc2.setTypeface(null,Typeface.NORMAL);
                        c2b.setVisibility(View.INVISIBLE);
                        c2.setVisibility(View.VISIBLE);
                    }
                    circle_num=6;
                    textc6.setTextColor(Color.WHITE);
                    textc6.setTypeface(null,Typeface.BOLD);
                    c6.setVisibility(View.INVISIBLE);
                    c6b.setVisibility(View.VISIBLE);
                    break;
                }
                case 6:
                {
                    if(circle_num==2)
                    {
                        textc2.setTextColor(Color.BLACK);
                        textc2.setTypeface(null,Typeface.NORMAL);
                        c2b.setVisibility(View.INVISIBLE);
                        c2.setVisibility(View.VISIBLE);
                    }
                    if(circle_num==6)
                    {
                        textc6.setTextColor(Color.BLACK);
                        textc6.setTypeface(null,Typeface.NORMAL);
                        c6b.setVisibility(View.INVISIBLE);
                        c6.setVisibility(View.VISIBLE);
                    }
                    circle_num=7;
                    textc7.setTextColor(Color.WHITE);
                    textc7.setTypeface(null,Typeface.BOLD);
                    c7.setVisibility(View.INVISIBLE);
                    c7b.setVisibility(View.VISIBLE);
                    break;
                }
                case 2:
                {
                    if(circle_num==7)
                    {
                        textc7.setTextColor(Color.BLACK);
                        textc7.setTypeface(null,Typeface.NORMAL);
                        c7b.setVisibility(View.INVISIBLE);
                        c7.setVisibility(View.VISIBLE);
                    }
                    if(circle_num==6)
                    {
                        textc6.setTextColor(Color.BLACK);
                        textc6.setTypeface(null,Typeface.NORMAL);
                        c6b.setVisibility(View.INVISIBLE);
                        c6.setVisibility(View.VISIBLE);
                    }
                    if(circle_num==2)
                    {
                        textc2.setTextColor(Color.BLACK);
                        textc2.setTypeface(null,Typeface.NORMAL);
                        c2b.setVisibility(View.INVISIBLE);
                        c2.setVisibility(View.VISIBLE);
                    }
                    circle_num=3;
                    textc3.setTextColor(Color.WHITE);
                    textc3.setTypeface(null,Typeface.BOLD);
                    c3.setVisibility(View.INVISIBLE);
                    c3b.setVisibility(View.VISIBLE);
                    break;
                }
                case 0:
                {
                    if(circle_num==2)
                    {
                        textc2.setTextColor(Color.BLACK);
                        textc2.setTypeface(null,Typeface.NORMAL);
                        c2b.setVisibility(View.INVISIBLE);
                        c2.setVisibility(View.VISIBLE);
                    }
                    if(circle_num==3)
                    {
                        textc3.setTextColor(Color.BLACK);
                        textc3.setTypeface(null,Typeface.NORMAL);
                        c3b.setVisibility(View.INVISIBLE);
                        c3.setVisibility(View.VISIBLE);
                    }
                    textc1.setTextColor(Color.WHITE);
                    textc1.setTypeface(null,Typeface.BOLD);
                    c1.setVisibility(View.INVISIBLE);
                    c1b.setVisibility(View.VISIBLE);
                    break;
                }
                case 7:
                {
                    textc1.setTextColor(Color.BLACK);
                    textc1.setTypeface(null,Typeface.NORMAL);
                    c1.setVisibility(View.VISIBLE);
                    c1b.setVisibility(View.INVISIBLE);
                    break;
                }
                default:
                    break;
            }
            if(temp[i] != 7 )
            {
                result.setText(result.getText() + "  " + String.valueOf(saveData[temp[i]]));
                result.setVisibility(View.VISIBLE);
            }
        }
        i++;
    }
}