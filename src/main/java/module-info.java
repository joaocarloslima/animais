module br.com.joaocarloslima {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.opencsv;
    
    opens br.com.joaocarloslima to javafx.fxml;
    exports br.com.joaocarloslima;
}
