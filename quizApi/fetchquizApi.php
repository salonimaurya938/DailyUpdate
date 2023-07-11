<?php
   $conn=mysqli_connect("localhost","root","","question_answer")or die("error");
   $sql="SELECT * FROM `quiz`";
   $query=mysqli_query($conn,$sql);
   while($row = mysqli_fetch_assoc($query)){   
   if($row){       
       $data[]=$row;
   echo json_encode($data);
   }else{
    $data['code'] = 202;
    $data['msg'] = 'Invalid Credential.';
    echo json_encode($data);
   }
}  
?>