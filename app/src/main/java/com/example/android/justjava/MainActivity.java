package com.example.android.justjava;

/**
 * Add your package below. Package name can be found in the project's AndroidManifest.xml file.
 * This is the package name our example uses:
 * <p>
 * package com.example.android.justjava;
 */

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {

    /**
     * Global variables.
     **/
    int quantity = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        String orderSummary = createOrderSummary("Saeed", quantity, calculatePrice(quantity, 5));
        displayMessage(orderSummary);
    }

    /**
     * this method will increment the quantity
     */
    public void increment(View view) {
        quantity++;
        displayQuantity(quantity);
    }

    /**
     * this method will decrement the quantity
     */
    public void decrement(View view) {
        quantity--;
        displayQuantity(quantity);
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void displayQuantity(int numberOfCoffees) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + numberOfCoffees);
    }


//    /**
//     * This method displays the given price on the screen.
//     */
//    private void displayPrice(int number) {
//        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
//        priceTextView.setText(NumberFormat.getCurrencyInstance().format(number));
//    }

    /**
     * This method displays the given text on the screen.
     */
    private void displayMessage(String message) {
        TextView orderSummaryTextView = (TextView) findViewById(R.id.order_summary_text_view);
        orderSummaryTextView.setText(message);
    }


    /**
     * This method calculates the price of a given quantity of coffees.
     *
     * @param quantity    of number of coffees to order.
     * @param currentCost of the cup of coffee.
     */
    private int calculatePrice(int quantity, int currentCost) {
        int price = quantity * currentCost;
        return price;
    }

    /**
     * This method creates an order summary text.
     *
     * @param name     person who ordered.
     * @param quantity of number of coffees to order.
     * @param price    of total cost
     */
    private String createOrderSummary(String name, int quantity, int price) {
        String summary = "Name: " + name + "\nQuantity: " + quantity + "\nTotal: $" + price + "\nThank you! Please order again and again.";
        return summary;
    }


}
