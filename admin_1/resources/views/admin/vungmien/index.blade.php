@extends('layouts.dashboard')
@section('content')
<div class="content-header">
    <div class="container-fluid">
        <div class="row mb-2">
            <div class="col-sm-4">
                <h1 class="m-0 text-dark">Vùng miền</h1>
            </div><!-- /.col -->
            <div class="col-sm-4">
                <form type="get" action="{{url('/search/Vungmien')}}">
                    <div class="input-group mb-3">
                        <input name="query" type="text" class="form-control" placeholder="Tên">
                        <div class="input-group-append">
                            <button class="btn btn-navbar" type="submit">
                                <i class="fas fa-search" aria-hidden="true"></i>
                            </button>
                        </div>
                    </div>
                </form>
            </div><!-- /.col -->
            <div class="col-sm-4">
                <ol class="breadcrumb float-sm-right">
                    <li class="breadcrumb-item"><a href="{{route('home')}}">Dashboard</a></li>
                    <li class="breadcrumb-item active">Vùng miền</li>
                </ol>
            </div><!-- /.col -->
        </div><!-- /.row -->
    </div><!-- /.container-fluid -->
</div>

<section class="content">
    <div class="container-fluid">
        <p>
            <a href="{{route('home.vungmien.create')}}" class="btn btn-primary">Thêm mới vùng miền</a>
        </p>

        <table class="table table-bordered table-striped">
            <tr>
                <th>ID</th>
                <th>Tên</th>
                <th>Nội dung</th>
                <th>Action</th>
            </tr>
            @foreach($vungmien as $value)
            <tr>
                <td>{{$value->id}}</td>
                <td>{{$value->ten_vungmien}}</td>
                <td>{{$value->noidung}}</td>
                <td><a href="{{route('home.vungmien.edit',$value->id)}}" class="btn btn-success">Edit</a>
                    <a href="javascript:void(0)" onclick="$(this).parent().find('form').submit()"
                        class="btn btn-secondary">Delete</a>
                    <form action="{{route('home.vungmien.destroy',$value->id )}}" method="post">
                        @method('DELETE')
                        <input type="hidden" name="_token" value="{{csrf_token()}}">
                    </form>
                </td>
            </tr>
            @endforeach
        </table>
        <div class="row">
            <div class="col-sm-6"> </div>
            <div class="col-sm-6"> {{$vungmien->links()}}</div>
        </div>
    </div>
</section>
@endsection