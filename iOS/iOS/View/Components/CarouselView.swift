//
//  ImageSlideView.swift
//  iOS
//
//  Created by 김지현 on 2023/07/28.
//

import SwiftUI

struct CarouselView: View {
	private let timer = Timer.publish(every: 1, on: .main, in: .common).autoconnect()
    @State private var index = 1
    @State private var selectedNum: String = ""
	private var images: [String] = ["slide1", "slide2", "slide3"]
	
	var body: some View {
		TabView(selection: $selectedNum) {
            ForEach(carouselData, id: \.id) {
                Image($0.image)
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

struct CarouselView_Previews: PreviewProvider {
	static var previews: some View {
        CarouselView()
	}
}
