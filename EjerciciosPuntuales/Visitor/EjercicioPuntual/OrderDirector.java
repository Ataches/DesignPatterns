public class OrderDirector {
  private Order builder;

  public OrderDirector(Order bldr) {
    builder = bldr;
  }
  public void build() {
    builder.addUIControls();
  }

}

