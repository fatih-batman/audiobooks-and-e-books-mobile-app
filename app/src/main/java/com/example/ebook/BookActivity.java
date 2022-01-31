package com.example.ebook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.RelativeLayout;

import java.util.ArrayList;
import java.util.List;

public class BookActivity extends AppCompatActivity {
    List<Book> bookList;
    RecyclerView recyclerView;
    Button sender,senderAudio;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_activity);
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.anim_about_card_show);
        RelativeLayout relativeLayout = findViewById(R.id.rl);
        relativeLayout.startAnimation(animation);
        //getting the recyclerview from xml
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        sender=findViewById(R.id.btn_send);
        sender.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent go=new Intent(BookActivity.this,StatiscticActivity.class);
                startActivity(go);
            }
        });

        senderAudio=findViewById(R.id.btn_send_audio);
        senderAudio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent go=new Intent(BookActivity.this,AudioBookViewActivity.class);
                startActivity(go);
            }
        });


        //initializing the productlist
        bookList = new ArrayList<>();


        //adding some items to our list
        bookList.add(
                new Book(
                        1,
                        "Assignment_Outline\n",
                        R.drawable.pdflogo,
                        "https://firebasestorage.googleapis.com/v0/b/ebookprototype.appspot.com/o/Assignment_Outline.pdf?alt=media&token=8d5a4ec9-a654-4aad-a1f6-da7d0371b3f0"

                ));

        bookList.add(
                new Book(
                        2,
                        "Assignment_Outline\n",
                        R.drawable.pdflogo,
                        "https://firebasestorage.googleapis.com/v0/b/ebookprototype.appspot.com/o/tarkan-dudu.mp3?alt=media&token=ecd7c473-d98c-42f1-a26e-b617300e0be3"

                ));



        //creating recyclerview adapter
        BookAdapter adapter = new BookAdapter(this, bookList);

        //setting adapter to recyclerview
        recyclerView.setAdapter(adapter);
    }

}
