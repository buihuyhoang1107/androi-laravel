@extends('layouts.dashboard')
@section('content')
<div class="content-header">
	<div class="container-fluid">
		<div class="row mb-2">
			<div class="col-sm-6">
				<h1 class="m-0 text-dark">Thêm bài viết</h1>
			</div><!-- /.col -->
			<div class="col-sm-6">
				<ol class="breadcrumb float-sm-right">
					<li class="breadcrumb-item"><a href="{{route('home')}}">Dashboard</a></li>
					<li class="breadcrumb-item active">Thêm bài viết</li>
				</ol>
			</div><!-- /.col -->
		</div><!-- /.row -->
	</div><!-- /.container-fluid -->
</div>    

<section class="content">
	<div class="container-fluid">
		<form method="post" action="{{route('home.baiviet.store')}}" enctype="multipart/form-data">
			<input type="hidden" name="_token" value="{{csrf_token()}}">
			<div class="form-group">	
				<div class="row">	
					<label class="col-md-3">Tên</label>
					<div class="col-md-6"><input type="text" name="ten" class="form-control"required></div>
					<div class="clearfix"></div>
				</div>
			</div>
            <div class="form-group">	
				<div class="row">	
					<label class="col-md-3">Nguyên Liệu</label>
					<div class="col-md-6"><textarea name="nguyenlieu" class="form-control" required></textarea></div>
					<div class="clearfix"></div>
				</div>
			</div>
            <div class="form-group">	
				<div class="row">	
					<label class="col-md-3">Sơ chế</label>
					<div class="col-md-6"><textarea name="soche" class="form-control" required></textarea></div>
					<div class="clearfix"></div>
				</div>
			</div>
            <div class="form-group">	
				<div class="row">	
					<label class="col-md-3">Thực hiện</label>
					<div class="col-md-6"><textarea name="thuchien" class="form-control" required></textarea></div>
					<div class="clearfix"></div>
				</div>
			</div>
            <div class="form-group">	
				<div class="row">	
					<label class="col-md-3">cách dùng</label>
					<div class="col-md-6"> <textarea name="cachdung" class="form-control" required></textarea> </div>
					<div class="clearfix"></div>
				</div>
			</div>
            <div class="form-group">	 
				<div class="row">	
					<label class="col-md-3">Hình ảnh</label>
					<div class="col-md-6"><input type="file" name="hinhanh" required></div> 
				</div>
			</div>

            <div class="form-group">	
				<div class="row">
                <label class="col-md-3"></label>	
                <select name="category_id" class="form-control col-md-6 ">
                     <!-- <option value="">Chọn thể loại</option>  -->
                     @foreach($categories as $category)
                     <option value="{{ $category->id}}">{{$category->title}}</option>
                     @endforeach
                 </select>
					<div class="clearfix"></div>
				</div>
			</div>

            <div class="form-group">	
				<div class="row">
                <label class="col-md-3"></label>	
                <select name="vungmien_id" class="form-control col-md-6 ">
                     <!-- <option value="">Chọn vùng miền</option>  -->
                     @foreach($vungmiens as $vungmien)
                     <option value="{{$vungmien->id}}">{{$vungmien->ten_vungmien}}</option>
                     @endforeach
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