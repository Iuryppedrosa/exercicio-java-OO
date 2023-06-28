package entities;

import entities.enuns.OrderStatus;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Order {
    private Date moment;
    private OrderStatus status;

    private Client client;

    private List<OrderItem> items = new ArrayList<>();
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

    public Order() {
    }

    public Order(Date moment, OrderStatus status, Client client) {
        this.moment = moment;
        this.status = status;
        this.client = client;
    }

    public Date getMoment() {
        return moment;
    }

    public void setMoment(Date moment) {
        this.moment = moment;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public void addItem(OrderItem item)
    {
        items.add(item);
    }

    public void removeItem(OrderItem item){
        items.remove(item);
    }

    public double total()
    {
        double sum = 0.0;
        for(OrderItem orderItem : items)
        {
            sum += orderItem.subTotal();
        }
        return sum;
    }

    @Override
    public String toString() {
        StringBuilder strb = new StringBuilder();

        strb.append("Order moment: ");
        strb.append(sdf.format(moment)).append("\n");
        strb.append("Order Status: ").append(status).append("\n");
        strb.append(client).append("\n");
        strb.append("Ordem items: ");
        for(OrderItem orderItem : items)
        {
            strb.append(orderItem).append("\n");
        }

        strb.append("Total price: $");
        strb.append(String.format("%.2f", total()));


        return strb.toString();
    }
}
