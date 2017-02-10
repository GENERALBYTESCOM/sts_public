#!/bin/bash
echo Generating binary files...
java -cp ./out/production/rng_recorder com.generalbytes.sts.recorder.RNGRecorder bin rng_bin_0001.bin 1 0xffff0000 960000000
java -cp ./out/production/rng_recorder com.generalbytes.sts.recorder.RNGRecorder bin rng_bin_0002.bin 1 0x1a2393b0 960000000
java -cp ./out/production/rng_recorder com.generalbytes.sts.recorder.RNGRecorder bin rng_bin_0003.bin 1 0xffff0000 960000000
java -cp ./out/production/rng_recorder com.generalbytes.sts.recorder.RNGRecorder bin rng_bin_0004.bin 1 0x0 9600000 0x28f5c28 9600000 0x51eb850 9600000 0x7ae1478 9600000 0xa3d70a0 9600000 0xcccccc8 9600000 0xf5c28f0 9600000 0x11eb8518 9600000 0x147ae140 9600000 0x170a3d68 9600000 0x19999990 9600000 0x1c28f5b8 9600000 0x1eb851e0 9600000 0x2147ae08 9600000 0x23d70a30 9600000 0x26666658 9600000 0x28f5c280 9600000 0x2b851ea8 9600000 0x2e147ad0 9600000 0x30a3d6f8 9600000 0x33333320 9600000 0x35c28f48 9600000 0x3851eb70 9600000 0x3ae14798 9600000 0x3d70a3c0 9600000 0x3fffffe8 9600000 0x428f5c10 9600000 0x451eb838 9600000 0x47ae1460 9600000 0x4a3d7088 9600000 0x4cccccb0 9600000 0x4f5c28d8 9600000 0x51eb8500 9600000 0x547ae128 9600000 0x570a3d50 9600000 0x59999978 9600000 0x5c28f5a0 9600000 0x5eb851c8 9600000 0x6147adf0 9600000 0x63d70a18 9600000 0x66666640 9600000 0x68f5c268 9600000 0x6b851e90 9600000 0x6e147ab8 9600000 0x70a3d6e0 9600000 0x73333308 9600000 0x75c28f30 9600000 0x7851eb58 9600000 0x7ae14780 9600000 0x7d70a3a8 9600000 0x7fffffd0 9600000 0x828f5bf8 9600000 0x851eb820 9600000 0x87ae1448 9600000 0x8a3d7070 9600000 0x8ccccc98 9600000 0x8f5c28c0 9600000 0x91eb84e8 9600000 0x947ae110 9600000 0x970a3d38 9600000 0x99999960 9600000 0x9c28f588 9600000 0x9eb851b0 9600000 0xa147add8 9600000 0xa3d70a00 9600000 0xa6666628 9600000 0xa8f5c250 9600000 0xab851e78 9600000 0xae147aa0 9600000 0xb0a3d6c8 9600000 0xb33332f0 9600000 0xb5c28f18 9600000 0xb851eb40 9600000 0xbae14768 9600000 0xbd70a390 9600000 0xbfffffb8 9600000 0xc28f5be0 9600000 0xc51eb808 9600000 0xc7ae1430 9600000 0xca3d7058 9600000 0xcccccc80 9600000 0xcf5c28a8 9600000 0xd1eb84d0 9600000 0xd47ae0f8 9600000 0xd70a3d20 9600000 0xd9999948 9600000 0xdc28f570 9600000 0xdeb85198 9600000 0xe147adc0 9600000 0xe3d709e8 9600000 0xe6666610 9600000 0xe8f5c238 9600000 0xeb851e60 9600000 0xee147a88 9600000 0xf0a3d6b0 9600000 0xf33332d8 9600000 0xf5c28f00 9600000 0xf851eb28 9600000 0xfae14750 9600000 0xfd70a378 9600000 
java -cp ./out/production/rng_recorder com.generalbytes.sts.recorder.RNGRecorder num rng_num_0001.txt 2 0xffff0000 1000000
java -cp ./out/production/rng_recorder com.generalbytes.sts.recorder.RNGRecorder num rng_num_0002.txt 5 0xffff0000 1000000
java -cp ./out/production/rng_recorder com.generalbytes.sts.recorder.RNGRecorder num rng_num_0003.txt 8 0xffff0000 1000000
java -cp ./out/production/rng_recorder com.generalbytes.sts.recorder.RNGRecorder num rng_num_0004.txt 20 0xffff0000 1000000
java -cp ./out/production/rng_recorder com.generalbytes.sts.recorder.RNGRecorder num rng_num_0005.txt 35 0xffff0000 1000000
java -cp ./out/production/rng_recorder com.generalbytes.sts.recorder.RNGRecorder num rng_num_0006.txt 51 0xffff0000 1000000
java -cp ./out/production/rng_recorder com.generalbytes.sts.recorder.RNGRecorder num rng_num_0007.txt 53 0xffff0000 1000000
java -cp ./out/production/rng_recorder com.generalbytes.sts.recorder.RNGRecorder num rng_num_0008.txt 63 0xffff0000 1000000
java -cp ./out/production/rng_recorder com.generalbytes.sts.recorder.RNGRecorder num rng_num_0009.txt 99 0xffff0000 1000000
java -cp ./out/production/rng_recorder com.generalbytes.sts.recorder.RNGRecorder num rng_num_0010.txt 127 0xffff0000 1000000
java -cp ./out/production/rng_recorder com.generalbytes.sts.recorder.RNGRecorder num rng_num_0011.txt 1225 0xffff0000 1000000
java -cp ./out/production/rng_recorder com.generalbytes.sts.recorder.RNGRecorder num rng_num_0012.txt 1799 0xffff0000 1000000
java -cp ./out/production/rng_recorder com.generalbytes.sts.recorder.RNGRecorder num rng_num_0013.txt 2559 0xffff0000 1000000
java -cp ./out/production/rng_recorder com.generalbytes.sts.recorder.RNGRecorder num rng_num_0014.txt 2559 0x0 10000 0x28f5c28 10000 0x51eb850 10000 0x7ae1478 10000 0xa3d70a0 10000 0xcccccc8 10000 0xf5c28f0 10000 0x11eb8518 10000 0x147ae140 10000 0x170a3d68 10000 0x19999990 10000 0x1c28f5b8 10000 0x1eb851e0 10000 0x2147ae08 10000 0x23d70a30 10000 0x26666658 10000 0x28f5c280 10000 0x2b851ea8 10000 0x2e147ad0 10000 0x30a3d6f8 10000 0x33333320 10000 0x35c28f48 10000 0x3851eb70 10000 0x3ae14798 10000 0x3d70a3c0 10000 0x3fffffe8 10000 0x428f5c10 10000 0x451eb838 10000 0x47ae1460 10000 0x4a3d7088 10000 0x4cccccb0 10000 0x4f5c28d8 10000 0x51eb8500 10000 0x547ae128 10000 0x570a3d50 10000 0x59999978 10000 0x5c28f5a0 10000 0x5eb851c8 10000 0x6147adf0 10000 0x63d70a18 10000 0x66666640 10000 0x68f5c268 10000 0x6b851e90 10000 0x6e147ab8 10000 0x70a3d6e0 10000 0x73333308 10000 0x75c28f30 10000 0x7851eb58 10000 0x7ae14780 10000 0x7d70a3a8 10000 0x7fffffd0 10000 0x828f5bf8 10000 0x851eb820 10000 0x87ae1448 10000 0x8a3d7070 10000 0x8ccccc98 10000 0x8f5c28c0 10000 0x91eb84e8 10000 0x947ae110 10000 0x970a3d38 10000 0x99999960 10000 0x9c28f588 10000 0x9eb851b0 10000 0xa147add8 10000 0xa3d70a00 10000 0xa6666628 10000 0xa8f5c250 10000 0xab851e78 10000 0xae147aa0 10000 0xb0a3d6c8 10000 0xb33332f0 10000 0xb5c28f18 10000 0xb851eb40 10000 0xbae14768 10000 0xbd70a390 10000 0xbfffffb8 10000 0xc28f5be0 10000 0xc51eb808 10000 0xc7ae1430 10000 0xca3d7058 10000 0xcccccc80 10000 0xcf5c28a8 10000 0xd1eb84d0 10000 0xd47ae0f8 10000 0xd70a3d20 10000 0xd9999948 10000 0xdc28f570 10000 0xdeb85198 10000 0xe147adc0 10000 0xe3d709e8 10000 0xe6666610 10000 0xe8f5c238 10000 0xeb851e60 10000 0xee147a88 10000 0xf0a3d6b0 10000 0xf33332d8 10000 0xf5c28f00 10000 0xf851eb28 10000 0xfae14750 10000 0xfd70a378 10000 