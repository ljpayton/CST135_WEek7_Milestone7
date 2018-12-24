package application;
import java.util.LinkedList;

import javafx.animation.PauseTransition;
import javafx.animation.TranslateTransition;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.util.Duration;

public class CustomerDisplay {
	VBox vbox;
	ImageView customerImage;
	LinkedList<Customer> customerLinkedList;
	Customer customer;
	static double positionHeight = (Main.getStage().getHeight()/2);
	static double positionWidth = (Main.getStage().getWidth() / 8);
	
	
	public CustomerDisplay(LinkedList<Customer> customers) {
		customerLinkedList = customers;
	}
	
	public CustomerDisplay(Customer customerToAnimate) {
		customer = customerToAnimate;
		customerImage = customer.getImageView();
	}
	
	
	
	
	public CustomerDisplay(VBox newCustomer) {
		vbox = newCustomer;
		//customerImage = ((Customer) vbox.getChildren()).getImageView();
		//customer = (Customer) vbox.getChildren();
	}
	

	public static void moveCustomer(Customer customerToAnimate) {
		TranslateTransition moveToPositionAnimation = new TranslateTransition(Duration.millis(1000), customerToAnimate.getImageView());
		PauseTransition pause = new PauseTransition(Duration.millis(10000));
		pause.play();
		//moveToPositionAnimation.setToX(positionWidth);
		moveToPositionAnimation.setToY(50);
		moveToPositionAnimation.setCycleCount(1);
		moveToPositionAnimation.play();			
	}
	
	

	
	public void moveCustomers(LinkedList<Customer> customers) {
		for(int i = 0; i < customers.size(); i++) {
			TranslateTransition moveToPosition = new TranslateTransition(Duration.millis(1000), customers.get(i).getImageView());
			PauseTransition pause = new PauseTransition(Duration.millis(10000));
			pause.play();
			moveToPosition.setToY(50);
			moveToPosition.setCycleCount(1);
			moveToPosition.play();			
		}
	}
	
	public void moveToPosition(Customer customer) {
		TranslateTransition moveToPosition = new TranslateTransition(Duration.millis(10000), customer.getImageView());
		//moveToPosition.setToX(positionWidth);
		moveToPosition.setToY(-50);
		moveToPosition.setCycleCount(1);
		moveToPosition.play();
	}

	public static void disappear(TranslateTransition animation) {
		animation.setToY(100);
		animation.setCycleCount(1);
		animation.play();
	}

	public static void moveCustomer(VBox newCustomer, Image image) {
		TranslateTransition moveToPositionAnimation = new TranslateTransition(Duration.millis(1000), newCustomer);
		//moveToPositionAnimation.setToX(positionWidth);
		moveToPositionAnimation.setToY(-50);
		moveToPositionAnimation.setCycleCount(1);
		moveToPositionAnimation.play();
		moveToPositionAnimation.setOnFinished(e -> 	{
			disappear(moveToPositionAnimation);
		});

		
		Image sourceImage = image;
		ImageView copyImageViewToAnimate = new ImageView();
		copyImageViewToAnimate.setImage(sourceImage);
		
		
		TranslateTransition moveProductToCustomerAnimation = new TranslateTransition(Duration.millis(1000), copyImageViewToAnimate);
		//moveToPositionAnimation.setToX(positionWidth);
		moveProductToCustomerAnimation.setToY(-50);
		moveProductToCustomerAnimation.setCycleCount(1);
		moveProductToCustomerAnimation.play();

		
		
		
		
	
		
	}

}





//
//ImageView imageToAnimate;
//
//public void AnimatedProduct(ImageView imageToAnimate){
//	Image sourceImage = imageToAnimate.getImage();
//	ImageView copyImageViewToAnimate = new ImageView();
//	copyImageViewToAnimate.setImage(sourceImage);
//}
//
//Image sourceImage = new Image("http://goo.gl/kYEQl");
//ImageView imageView = new ImageView();
//imageView.setImage(sourceImage);
//ImageView destImageView = new ImageView();
//
//// copying sourceImage
//destImageView.setImage(SwingFXUtils.toFXImage(SwingFXUtils.fromFXImage(sourceImage,null),null));
//
//VBox vBox = new VBox();
//vBox.getChildren().addAll(imageView,destImageView);
//StackPane root = new StackPane();root.getChildren().add(vBox);
//Scene scene = new Scene(root, 300,
//		300);primaryStage.setTitle("java-buddy.blogspot.com");primaryStage.setScene(scene);primaryStage.show();
//
//public void dropInCart(ImageView productImage) {
//	productImage.toFront();
//	TranslateTransition dropToCart = new TranslateTransition(Duration.millis(10000), productImage);
//	dropToCart.setFromY(0);
//	dropToCart.setToY(10000);
//	dropToCart.setCycleCount(1);
//	dropToCart.play();
//}
//
//public void putBack(ImageView productImage) {
//	TranslateTransition dropToCart = new TranslateTransition(Duration.millis(10), productImage);
//	dropToCart.setFromY(10000);
//	dropToCart.setToY(0);
//	dropToCart.setCycleCount(1);
//	dropToCart.play();
//}
