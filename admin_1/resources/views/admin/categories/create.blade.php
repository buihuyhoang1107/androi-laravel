@extends('layouts.dashboard')
@section('content')
<div class="content-header">
	<div class="container-fluid">
		<div class="row mb-2">
			<div class="col-sm-6">
				<h1 class="m-0 text-dark">Add Categories</h1>
			</div><!-- /.col -->
			<div class="col-sm-6">
				<ol class="breadcrumb float-sm-right">
					<li class="breadcrumb-item"><a href="{{route('home')}}">Dashboard</a></li>
					<li class="breadcrumb-item active">Add Categories</li>
				</ol>
			</div><!-- /.col -->
		</div><!-- /.row -->
	</div><!-- /.container-fluid -->
</div>    

<section class="content">
	<div class="container-fluid">
		<form method="post" runat="server" action="{{route('home.categories.store')}}" enctype="multipart/form-data">
			<input type="hidden" name="_token" value="{{csrf_token()}}">
			<div class="form-group">	
				<div class="row">	
					<label class="col-md-3">Title</label>
					<div class="col-md-6"><input type="text" name="title" class="form-control" required></div>
					<div class="clearfix"></div>
				</div>
			</div>
			<div class="form-group">	 
				<div class="row">	
					<label class="col-md-3">Hình ảnh</label>
					<div class="col-md-6">
					<input type='file' id="imgInp" name="hinhanh"/>
					<br/>
 						 <img id="blah" src="#" alt="your image" class=""width="200" height="150" />
					</div> 
				</div>
			</div>
			<div class="form-group">
				<input type="submit" class="btn btn-success" value=" Save">
			</div>
		</form>
	</div>
</section>
@endsection
@section('scripts')
<script>
    function readURL(input) {
  if (input.files && input.files[0]) {
    var reader = new FileReader();
    
    reader.onload = function(e) {
      $('#blah').attr('src', e.target.result);
    }
    
    reader.readAsDataURL(input.files[0]); // convert to base64 string
  }
}

$("#imgInp").change(function() {
  readURL(this);
});
</script>
@endsection