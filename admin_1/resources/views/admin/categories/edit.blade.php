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
		<form method="post" action="{{route('home.categories.update',$category->id)}}" enctype="multipart/form-data">
		@method('PUT')
			<input type="hidden" name="_token" value="{{csrf_token()}}">
			<div class="form-group">	
				<div class="row">	
					<label class="col-md-3">Title</label>
					<div class="col-md-6"><input type="text" name="title" class="form-control" value="{{$category->title}}"></div>
					<div class="clearfix"></div>
				</div>
			</div>
			<div class="form-group">	
				<div class="row">	
					<label class="col-md-3">Hình ảnh</label>
					<div class="col-md-9"><input type="file" name="hinhanh"></div>
                    <div class="clearfix"></div>
                    @if($category->hinhanh)
                    <div class="col-md-3"></div>
                    <div class="col-md-9">
                     <img src="{{asset('storage/category/'.$category->hinhanh)}}" style="width:150px">
                    </div>
                    <div class="clearfix"></div>
                    @endif
				</div>
			</div>
			<div class="form-group">
				<input type="submit" class="btn btn-success" value=" Save">
			</div>
		</form>
	</div>
</section>
@endsection