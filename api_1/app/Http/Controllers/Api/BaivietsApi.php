<?php

namespace App\Http\Controllers\Api;

use App\Http\Controllers\Controller;
use Illuminate\Http\Request;
use App\Baiviets;
use DB;
use Validator;
class BaivietsApi extends Controller
{
    /**
     * Display a listing of the resource.
     *
     * @return \Illuminate\Http\Response
     */
    public function index()
    {
        $data = DB::table('baiviets')->get();

        return response()->json($data,200);
    }

    /**
     * Show the form for creating a new resource.
     *
     * @return \Illuminate\Http\Response
     */
    public function create()
    {
        $baiviet=Baiviets::find($id);
        if(is_null($baiviet)){
            return response()->json(["messge"=>"Record not found"],404);
        }
        return response()->json($baiviet,200);
    }

    /**
     * Store a newly created resource in storage.
     *
     * @param  \Illuminate\Http\Request  $request
     * @return \Illuminate\Http\Response
     */
    public function store(Request $request)
    {
        $rule=['ten'=>'required|min:3'];
        $validator=Validator::make($request->all(),$rule);
        if($validator->fails()){
            return response()->json($validator->errors(),400);
        }
        $baiviet = Baiviets::create($request->all());
        return response()->json($baiviet,201);
    }

    /**
     * Display the specified resource.
     *
     * @param  int  $id
     * @return \Illuminate\Http\Response
     */
    public function show($id)
    {
        //
    }

    /**
     * Show the form for editing the specified resource.
     *
     * @param  int  $id
     * @return \Illuminate\Http\Response
     */
    public function edit($id)
    {
        //
    }

    /**
     * Update the specified resource in storage.
     *
     * @param  \Illuminate\Http\Request  $request
     * @param  int  $id
     * @return \Illuminate\Http\Response
     */
    public function update(Request $request, $id)
    {
        $baiviet=Baiviets::find($id);
        if(is_null($baiviet)){                                                                          
            return response()->json(["messge"=>"Record not found"],404);
        }
        $baiviet->update($request->all());
        return response()->json($baiviet,200);
    }

    /**
     * Remove the specified resource from storage.
     *
     * @param  int  $id
     * @return \Illuminate\Http\Response
     */
    public function destroy($id)
    {
        $baiviet=Baiviets::find($id);
        if(is_null($baiviet)){                                                                          
            return response()->json(["messge"=>"Record not found"],404);
        }
        $baiviet->delete();
        return response()->json(null,204);
    }
}