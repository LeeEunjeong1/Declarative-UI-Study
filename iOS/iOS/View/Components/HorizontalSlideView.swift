//
//  HorizontalSlideView.swift
//  iOS
//
//  Created by Financial CB on 2023/08/23.
//

import SwiftUI

struct HorizontalSlideView: View {
    private let timer = Timer.publish(every: 1, on: .main, in: .common).autoconnect()
    @State private var index = 1
    @State private var selectedNum: String = ""
    private let images: [String] = ["slide1", "slide2", "slide3"]
    
    var body: some View {
        TabView(selection: $selectedNum) {
            ForEach(images, id: \.self) {
                Image($0)
                    .resizable()
                    .scaledToFill()
            }
        }
        .tabViewStyle(.page)
        .onReceive(timer, perform: { _ in
            withAnimation {
                index = index < images.count ? index + 1 : 1
                selectedNum = images[index - 1]
            }
        })
    }
}

struct HorizontalSlideView_Previews: PreviewProvider {
    static var previews: some View {
        HorizontalSlideView()
    }
}
