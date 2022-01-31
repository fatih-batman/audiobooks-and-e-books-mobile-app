package com.example.ebook;
import android.content.Context;
import android.content.Intent;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.List;
public class BookAdapter extends RecyclerView.Adapter<BookAdapter.BookViewHolder>{
    //this context we will use to inflate the layout
    private Context mCtx;

    //we are storing all the products in a list
    private List<Book> bookList;

    //getting the context and product list with constructor
    public BookAdapter(Context mCtx, List<Book> BookList) {
        this.mCtx = mCtx;
        this.bookList = BookList;
    }

    @Override
    public BookViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //inflating and returning our view holder
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.layout_products, null);
        return new BookViewHolder(view);
    }

    @Override
    public void onBindViewHolder(BookViewHolder holder, final int position) {
        //getting the product of the specified position
        final Book book = bookList.get(position);

        //binding the data with the viewholder views

        holder.textViewTitle.setText(book.getTitle());


        holder.imageView.setImageDrawable(mCtx.getResources().getDrawable(book.getImage()));

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(v.getContext(), ViewPdfActivity.class);
                i.putExtra("title",bookList.get(position).getTitle());
                i.putExtra("product",bookList.get(position).getTitle());
                i.putExtra("link",bookList.get(position).getLink());
                mCtx.startActivity(i);

            }
        });
    }


    @Override
    public int getItemCount() {
        return bookList.size();
    }


    class BookViewHolder extends RecyclerView.ViewHolder {

        TextView textViewTitle;
        ImageView imageView;
        CardView cardView;
        public BookViewHolder(View itemView) {
            super(itemView);
            cardView = itemView.findViewById(R.id.cardview);// card intial
            textViewTitle = itemView.findViewById(R.id.textViewTitle);
            imageView = itemView.findViewById(R.id.imageView);
        }
    }
}
