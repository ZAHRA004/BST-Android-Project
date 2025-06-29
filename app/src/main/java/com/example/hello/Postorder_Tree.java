package com.example.hello;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Postorder_Tree extends AppCompatActivity {

    Button start;
    ImageView c1, c2, c3, c4, c5, c6, c7;//Tree circle variables
    ImageView c1l, c1r, c2l, c2r, c3l, c3r;//Tree arrow variables
    TextView textc1, textc2, textc3, textc4, textc5, textc6, textc7;//Text variables inside the tree
    TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_postorder_tree);

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

        result = findViewById(R.id.result);
        result.setVisibility(View.INVISIBLE);

        ActivityIntro intro = new ActivityIntro();

        for(int n=0; n<7; n++)
        {
            int saveData = intro.saveData[n];
            result.setText(String.valueOf(saveData));
            //int saveData = save[n];
            if(saveData > 0)
            {
                switch (n)
                {
                    case 0:
                    {
                        c1.setVisibility(View.VISIBLE);
                        textc1.setText((String.valueOf(saveData)));
                        textc1.setVisibility(View.VISIBLE);
                        break;
                    }
                    case 1:
                    {
                        c2.setVisibility(View.VISIBLE);
                        textc2.setText((String.valueOf(saveData)));
                        textc2.setVisibility(View.VISIBLE);
                        c1l.setVisibility(View.VISIBLE);
                        break;
                    }
                    case 2:
                    {
                        c3.setVisibility(View.VISIBLE);
                        textc3.setText((String.valueOf(saveData)));
                        textc3.setVisibility(View.VISIBLE);
                        c1r.setVisibility(View.VISIBLE);
                        break;
                    }
                    case 3:
                    {
                        c4.setVisibility(View.VISIBLE);
                        textc4.setText((String.valueOf(saveData)));
                        textc4.setVisibility(View.VISIBLE);
                        c2l.setVisibility(View.VISIBLE);
                        break;
                    }
                    case 4:
                    {
                        c5.setVisibility(View.VISIBLE);
                        textc5.setText((String.valueOf(saveData)));
                        textc5.setVisibility(View.VISIBLE);
                        c2r.setVisibility(View.VISIBLE);
                        break;
                    }
                    case 5:
                    {
                        c6.setVisibility(View.VISIBLE);
                        textc6.setText((String.valueOf(saveData)));
                        textc6.setVisibility(View.VISIBLE);
                        c3l.setVisibility(View.VISIBLE);
                        break;
                    }
                    case 6:
                    {
                        c7.setVisibility(View.VISIBLE);
                        textc7.setText((String.valueOf(saveData)));
                        textc7.setVisibility(View.VISIBLE);
                        c3r.setVisibility(View.VISIBLE);
                        break;
                    }
                    default:
                        break;
                }
            }
        }

        /*BST bst = new BST();
        start = (Button) findViewById(R.id.btn_start);
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            traversepostorder(bst.root);
            }
        });*/

    }

    public void traversepostorder(Node n){
        if(n == null){return;}
        traversepostorder(n.left);
        traversepostorder(n.right);
        result.setText(result.getText() + "," + n.value);
    }

    class Node {
        int value; // The value of the node
        Postorder_Tree.Node left; // The left child of the node
        Postorder_Tree.Node right; // The right child of the node

        // A constructor to create a new node with a given value
        public Node(int value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }
}