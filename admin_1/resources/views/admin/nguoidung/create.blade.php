@extends('layouts.dashboard')
@section('content')
<div class="content-header">
	<div class="container-fluid">
		<div class="row mb-2">
			<div class="col-sm-6">
				<h1 class="m-0 text-dark">Thêm người dùng</h1>
			</div><!-- /.col -->
			<div class="col-sm-6">
				<ol class="breadcrumb float-sm-right">
					<li class="breadcrumb-item"><a href="{{route('home')}}">Dashboard</a></li>
					<li class="breadcrumb-item active">Thêm người dùng</li>
				</ol>
			</div><!-- /.col -->
		</div><!-- /.row -->
	</div><!-- /.container-fluid -->
</div>    

<section class="content">
	<div class="container-fluid">
		<form method="post" action="{{route('home.nguoidung.store')}}" enctype="multipart/form-data">
			<input type="hidden" name="_token" value="{{csrf_token()}}">
			<div class="form-group">	
				<div class="row">	
					<label class="col-md-3">Tên</label>
					<div class="col-md-6"><input type="text" name="ten" class="form-control" required></div>
					<div class="clearfix"></div>
				</div>
			</div>
            <div class="form-group">	
				<div class="row">	
					<label class="col-md-3">Gmail</label>
					<div class="col-md-6"><input type="text" name="gmail" class="form-control" required></div>
					<div class="clearfix"></div>
				</div>
			</div>
            <div class="form-group">	
				<div class="row">	
					<label class="col-md-3">Mật khẩu</label>
					<div class="col-md-6"><input type="text" name="matkhau" class="form-control" required></div>
					<div class="clearfix"></div>
				</div>
			</div>

            <div class="form-group">	
				<div class="row">
                <label class="col-md-3">Phân quyền</label>	
                <select name="nguoidung_id" class="form-control col-md-6">
                     <option value="0">User</option>
                     <option value="1">Admin</option>              
                 </select>
					<div class="clearfix"></div>
				</div>
			</div>

			<div class="form-group">
				<input type="submit" class="btn btn-success btn-action" value=" Save">
			</div>
		</form>
	</div>
</section>
@endsection
<script language="javascript">
	// function swap(var $id){
	// 	$("#"+$id).attr('class','btn btn-outline-success');
	// }
	
$(".btn-action").on('click',function(e) {
	e.preventDefault();
	var id =($(this).attr("id"));
    $.ajax({
		type: "POST",
		dataType: "json",
		url: 'http://192.168.42.102:8000/api/nguoidungs/swap/'+id,
        success: function(data) {
			console.log(data);
			$(".btn-action#"+data.id).val((data.action==true)?'Mở Khóa':'Khóa');
			$(".btn-action#"+data.id).attr('class',(data.action==true)?'btn-action btn btn-outline-success':'btn-action btn btn-outline-danger');
        },
        error: function() {
            alert('Lỗi chương trình');
        }
    });
})
</script>