<?php

use Illuminate\Support\Facades\Schema;
use Illuminate\Database\Schema\Blueprint;
use Illuminate\Database\Migrations\Migration;

class CreatePatientAdmitTable extends Migration
{
    /**
     * Run the migrations.
     *
     * @return void
     */
    public function up()
    {
        Schema::create('patient_admit', function (Blueprint $table) {
            $table->increments('id');
            $table->integer('patient_id')->unsigned();
            $table->string('reason')->nullable();
            $table->string('recomended_by')->nullable();
            $table->integer('consultant')->nullable()->unsigned();
            $table->string('ward')->nullable();
            $table->integer('leading_doctor')->nullable()->unsigned();
            $table->datetime('admitted_on')->nullable();
            $table->datetime('discharged_on')->nullable();
        });
    }

    /**
     * Reverse the migrations.
     *
     * @return void
     */
    public function down()
    {
        Schema::dropIfExists('patient_admit');
    }
}
