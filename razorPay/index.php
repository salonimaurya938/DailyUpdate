
   <input type="textbox" name="name" id="name" Placeholder="Enter Your Name..."/>
    <br><br>
    <input type="textbox" name="amt" id="amt" Placeholder="Enter Amount..."/>
    <br><br>
    <button id="rzp-button1" onclick="payNow()">Pay Now</button>

<script src="https://code.jquery.com/jquery-3.7.0.min.js"></script>
<script src="https://checkout.razorpay.com/v1/checkout.js"></script>
<script>
function payNow(){
    var name   =jQuery('#name').val();
    var amt =jQuery('#amt').val();

    jQuery.ajax({
            type:'post',
            url:'payment_process.php',
            data:"&amt="+amt+"&name="+name,
            success:function(result){
                            var options = {
                        "key": "rzp_test_NvA7Q02xRKbDln",
                        "amount": amt*100, 
                        "currency": "INR",
                        "name": name,
                        "description": "Test Transaction",
                        "image": "logo.jpg",
                        "handler": function (response){
                        jQuery.ajax({
                        type:'post',
                        url:'payment_process.php',
                        data:"payment_id="+response.razorpay_payment_id,
                        success:function(result){
                            window.location.href="thanku.php";
                        }
                });
                }
            };
            var rzp1 = new Razorpay(options);
                rzp1.open();
                        }
                });
}
</script>