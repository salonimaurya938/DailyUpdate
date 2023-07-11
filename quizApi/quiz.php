<?php
$conn=mysqli_connect("localhost","root","","question_answer")or die("error");

$question = $_POST['question'];
$opa=$_POST['opa'];
$opb=$_POST['opb'];
$opc=$_POST['opc'];
$opd=$_POST['opd'];
$correct_answer = $_POST['correct_answer'];
date_default_timezone_set('Asia/Kolkata');
$currentTime = date('d-m-Y H:i A',time());

$sql="INSERT INTO `quiz`(`id`, `question`, `op_a`, `op_b`, `op_c`, `op_d`, `correct_answer`, `currentTime`) VALUES ('','$question','$opa','$opb','$opc','$opd','$correct_answer','$currentTime')";
$query=mysqli_query($conn, $sql);
if($query)
{
 $data['msg']="true";
 echo json_encode($data); 
}else{
 $data['code'] = 202;
 $data['msg'] = "False";
 echo json_encode($data);
 }
?>