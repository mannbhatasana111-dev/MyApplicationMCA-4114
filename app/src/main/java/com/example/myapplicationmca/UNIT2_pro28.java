package com.example.myapplicationmca;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class UNIT2_pro28 extends AppCompatActivity {

    ArrayList<Product> productList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_unit2_pro28);

        // Adding 10 Premium Devices (Ensure images exist in res/drawable)
        productList.add(new Product("S24 Ultra", "Samsung", "₹1,29,999", R.drawable.s24u));
        productList.add(new Product("iPhone 15 Pro", "Apple", "₹1,34,900", R.drawable.i15p));
        productList.add(new Product("S23 Ultra", "Samsung", "₹1,04,999", R.drawable.s23u));
        productList.add(new Product("iPhone 14 Plus", "Apple", "₹79,900", R.drawable.i14plus));
        productList.add(new Product("S22 Ultra", "Samsung", "₹84,999", R.drawable.s22u));
        productList.add(new Product("iPhone 13", "Apple", "₹52,900", R.drawable.i13));
        productList.add(new Product("S21 FE", "Samsung", "₹34,999", R.drawable.s21fe));
        productList.add(new Product("iPhone 12", "Apple", "₹44,900", R.drawable.i12));
        productList.add(new Product("S20 Plus", "Samsung", "₹29,999", R.drawable.s20p));
        productList.add(new Product("iPhone 11", "Apple", "₹38,900", R.drawable.i11));

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new ProductAdapter());
    }

    class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ViewHolder> {

        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_product, parent, false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
            Product current = productList.get(position);
            holder.txtName.setText(current.name);
            holder.txtBrand.setText(current.brand);
            holder.txtPrice.setText(current.price);
            holder.img.setImageResource(current.image);
        }

        @Override
        public int getItemCount() {
            return productList.size();
        }

        class ViewHolder extends RecyclerView.ViewHolder {
            TextView txtName, txtBrand, txtPrice;
            ImageView img;

            ViewHolder(View itemView) {
                super(itemView);
                txtName = itemView.findViewById(R.id.phoneName);
                txtBrand = itemView.findViewById(R.id.phoneBrand);
                txtPrice = itemView.findViewById(R.id.phonePrice);
                img = itemView.findViewById(R.id.phoneImage);
            }
        }
    }
}