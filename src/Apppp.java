import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.util.Arrays;;

public class Apppp extends Application {

    private Stage primaryStage;
    private Scene mainScene;
    private Scene LogScene;
    private Scene menuScene;
    private Scene scene1;
    private Scene scene2;
    private Scene scene3;
    private TextField phoneNumberField;
    private TextField verificationCodeField;
    private PasswordField passwordField;
    private Button sendCodeButton;
    private Button registerButton;
    private double cardNumber1 =  Math.round(10000 * Math.random());
    private int cardNumber = (int)cardNumber1;
    private String[] goods = {"可乐", "雪碧", "薯片", "巧克力"};
    private double[] prices = {3.0, 3.5, 4.0, 5.0};
    private int[] quantities = {2, 3, 1, 2};

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        createMainScene();
        createLogScene();
        createMenuScene();
        createInformationScene();
        createSettlementScene();
        createTurntableScene();
        primaryStage.setScene(mainScene);
        primaryStage.setTitle("MyShop");
        primaryStage.show();
    }

    private void createMainScene() {
        VBox root = new VBox(20);
        root.setPadding(new Insets(50));
        root.setAlignment(Pos.CENTER);
        Button loginBtn = new Button("登录系统");
        loginBtn.setOnAction(e -> {
            primaryStage.setScene(LogScene);
        });
        Button exitBtn = new Button("退出");
        exitBtn.setOnAction(e -> {
            primaryStage.close();
        });
        root.getChildren().addAll(loginBtn, exitBtn);
        mainScene = new Scene(root, 400, 400);
    }

    private void createLogScene(){
        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setPadding(new Insets(25, 25, 25, 25));

        Label phoneNumberLabel = new Label("手机号:");
        gridPane.add(phoneNumberLabel, 0, 0);
        phoneNumberField = new TextField();
        gridPane.add(phoneNumberField, 1, 0);

        Label verificationCodeLabel = new Label("验证码:");
        gridPane.add(verificationCodeLabel, 0, 1);
        verificationCodeField = new TextField();
        gridPane.add(verificationCodeField, 1, 1);

        Label passwordLabel = new Label("密码:");
        gridPane.add(passwordLabel, 0, 2);
        passwordField = new PasswordField();
        gridPane.add(passwordField, 1, 2);

        sendCodeButton = new Button("发送验证码");
        gridPane.add(sendCodeButton, 2, 1);

        registerButton = new Button("注册");
        gridPane.add(registerButton, 1, 3);
        registerButton.setOnAction(e -> {
            primaryStage.setScene(menuScene);
        });        

        LogScene = new Scene(gridPane, 400, 300);
        primaryStage.setScene(LogScene);
        primaryStage.setTitle("MyShop登录");
        primaryStage.show();  
    }

    private void createMenuScene() {
        VBox root = new VBox(20);
        root.setPadding(new Insets(50));
        root.setAlignment(Pos.CENTER);
        Button customerBtn = new Button("客户信息管理");
        customerBtn.setOnAction(e -> {
            primaryStage.setScene(scene1);
        });  
        Button checkoutBtn = new Button("购物结算");
        checkoutBtn.setOnAction(e -> {
            primaryStage.setScene(scene2);
        });  
        Button discountBtn = new Button("幸运转盘");
        discountBtn.setOnAction(e -> {
            primaryStage.setScene(scene3);
        });  
        Button logoutBtn = new Button("注销");
        logoutBtn.setOnAction(e -> {
            primaryStage.setScene(mainScene);
        });
        root.getChildren().addAll(customerBtn, checkoutBtn, discountBtn, logoutBtn);
        menuScene = new Scene(root, 400, 400);
    }

    private void createInformationScene(){
        VBox root = new VBox(20);
        root.setPadding(new Insets(50));
        root.setAlignment(Pos.CENTER);
        Label cardNumberLabel = new Label("您的会员卡号是：" + cardNumber);
        Button return1 = new Button("返回");
        return1.setOnAction(e -> {
            primaryStage.setScene(menuScene);
        });
        root.getChildren().addAll(cardNumberLabel,return1);
        scene1 = new Scene(root, 400, 300);
        primaryStage.setScene(scene1);
        primaryStage.setTitle("客户信息管理界面");
        primaryStage.show();   
    }
    
    private void createSettlementScene(){
        VBox root = new VBox(20);
        root.setPadding(new Insets(50));
        root.setAlignment(Pos.CENTER);
        double total = 0;
        for (int i = 0; i < goods.length; i++) {
            total += prices[i] * quantities[i];
        }
        double Discount = 0;
        Discount = total/100*3;
        Label Settlement1 = new Label("您购买的物品为：" + Arrays.toString(goods));
        Label Settlement2 = new Label("物品的单价分别是：" + Arrays.toString(prices));
        Label Settlement3 = new Label("您购买了"+"件" + Arrays.toString(quantities));
        Label Settlement4 = new Label("消费总额为：" + total);
        Label Settlement5 = new Label("总折扣为：" + Discount);
        Label Settlement6 = new Label("您实际缴费：" + (total-Discount));
        Button return2 = new Button("返回");
        return2.setOnAction(e -> {
            primaryStage.setScene(menuScene);
        });
        root.getChildren().addAll(Settlement1,Settlement2,Settlement3,Settlement4,Settlement5,Settlement6,return2);
        scene2 = new Scene(root, 400, 300);
        primaryStage.setScene(scene2);
        primaryStage.setTitle("购物结算");
        primaryStage.show();   
    }

    private void createTurntableScene(){
        VBox root = new VBox(20);
        root.setPadding(new Insets(50));
        root.setAlignment(Pos.CENTER);
        Label Turntable1 = new Label("幸运大转盘规则如下：" + "\n" + "客户的4位会员卡号的各位数字之和大于20"+"\n"+"则为幸运客户，实行免单");
        Label Turntable2 = new Label("您的会员卡号为：" + cardNumber);
        Label Turntable3 = new Label();
        Label Turntable4 = new Label();
        int a = cardNumber%10;
        int b = cardNumber/10%10;
        int c = cardNumber/100%10;
        int d = cardNumber/1000;
        boolean free = (a+b+c+d > 20);
        if(free){
            Turntable3 = new Label("恭喜您，您可以免单");
        }
        else{
            Turntable4 = new Label("很抱歉，您没有中奖");
        }
        Button return3 = new Button("返回");
        return3.setOnAction(e -> {
            primaryStage.setScene(menuScene);
        });
        root.getChildren().addAll(Turntable1,Turntable2,Turntable3,Turntable4,return3);
        scene3 = new Scene(root, 400, 300);
        primaryStage.setScene(scene3);
        primaryStage.setTitle("幸运大转盘");
        primaryStage.show();   
    }
}
