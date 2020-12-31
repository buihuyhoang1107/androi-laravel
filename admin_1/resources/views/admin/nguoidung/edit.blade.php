@extends('layouts.dashboard')
@section('content')
<div class="content-header">
	<div class="container-fluid">
		<div class="row mb-2">
			<div class="col-sm-6">
				<h1 class="m-0 text-dark">Edit Categories</h1>
			</div><!-- /.col -->
			<div class="col-sm-6">
				<ol class="breadcrumb float-sm-right">
					<li class="breadcrumb-item"><a href="{{route('home')}}">Dashboard</a></li>
					<li class="breadcrumb-item active">Edit Categories</li>
				</ol>
			</div><!-- /.col -->
		</div><!-- /.row -->
	</div><!-- /.container-fluid -->
</div>    

<section class="content">
	<div class="container-fluid">
		<form method="post" action="{{route('home.nguoidung.update',$nguoidung->id)}}" enctype="multipart/form-data">
		@method('PUT')
			<input type="hidden" name="_token" value="{{csrf_token()}}">
			<div class="form-group">	
				<div class="row">	
					<label class="col-md-3">Tên</label>
					<div class="col-md-6"><input type="text" name="ten" class="form-control" required value="{{$nguoidung->ten}}"></div>
					<div class="clearfix"></div>
				</div>
			</div>
            <div class="form-group">	
				<div class="row">	
					<label class="col-md-3">Gmail</label>
					<div class="col-md-6"><input type="text" name="gmail" class="form-control" required value="{{$nguoidung->gmail}}"></div>
					<div class="clearfix"></div>
				</div>
			</div>
            <div class="form-group">	
				<div class="row">	
					<label class="col-md-3">Mật khẩu</label>
					<div class="col-md-6"><input type="text" name="matkhau" class="form-control" required value="{{$nguoidung->matkhau}}"></div>
					<div class="clearfix"></div>
				</div>
			</div>

            <div class="form-group">	
				<div class="row">
                <label class="col-md-3">Phân quyền</label>	
                <select name="phanquyen" class="form-control col-md-6">
                     <option value="0">User</option>
                     <option value="1">Admin</option>              
                 </select>
					<div class="clearfix"></div>
				</div>
			</div>

            <div class="form-group">	
				<div class="row">
                <label class="col-md-3">Trạng thái</label>	
                <select name="action" class="form-control col-md-6 ">
                     <option value="0">Mở khóa</option>
                     <option value="1">Khóa</option>              
                 </select>
					<div class="clearfix"></div>
				</div>
			</div>
			<div class="form-group">
				<input type="submit" class="btn btn-success" value=" Save">
			</div>
		</form>
	</div>
</section>
@endsection