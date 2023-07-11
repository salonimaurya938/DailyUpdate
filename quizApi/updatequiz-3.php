<?php
$conn=mysqli_connect("localhost","root","","question_answer")or die("error");

$id= $_POST['id'];
$question = $_POST['question'];
$opa=$_POST['opa'];
$opb=$_POST['opb'];
$opc=$_POST['opc'];
$opd=$_POST['opd'];
$correct_answer = $_POST['correct_answer'];
date_default_timezone_set('Asia/Kolkata');
$currentTime = date('d-m-Y H:i A',time());


$sql="UPDATE `quiz` SET `id`='$id',`question`='$question',`op_a`='$opa',`op_b`='$opb',`op_c`='$opc',`op_d`='$opd',`correct_answer`='$correct_answer',`currentTime`='$currentTime' WHERE `id`=$id";
$query=mysqli_query($conn,$sql);
if($query)
{
$data['msg']="Update Successfull!";
 echo json_encode($data);
}else{
 $data['code'] = 202;
 $data['msg'] = "Invalid Credential!";
 echo json_encode($data);
}

?>